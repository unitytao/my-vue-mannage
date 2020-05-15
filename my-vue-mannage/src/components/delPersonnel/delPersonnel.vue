<template>
  <div>
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item>
          <i class="el-icon-lx-cascades"></i> 员工信息查询
        </el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="container">
      <div class="handle-box">
        <el-input v-model="query.name" placeholder="员工名称" class="handle-input mr10"></el-input>
        <el-button type="primary" icon="el-icon-search" @click="handleSearch()">名称搜索</el-button>
        <el-input v-model="query.id" placeholder="员工ID" class="handle-input mr10"></el-input>
        <el-button type="primary" icon="el-icon-search" @click="handleSearch2()">ID搜索</el-button>
      </div>
      <el-table
        :data="tableData"
        border
        class="table"
        ref="multipleTable"
        header-cell-class-name="table-header"
      >
        <el-table-column prop="id" label="ID" width="40" align="center"></el-table-column>
        <el-table-column prop="userName" label="姓名" width="75"></el-table-column>
        <el-table-column prop="gender" label="性别" width="50"></el-table-column>
        <el-table-column prop="birthday" label="生日"></el-table-column>
        <el-table-column prop="idCard" label="身份证号" width="200"></el-table-column>
        <el-table-column prop="departmentId" label="部门" width="50"></el-table-column>
        <el-table-column prop="positionId" label="岗位" width="50"></el-table-column>
        <el-table-column label="是否实习">
          <template slot-scope="scope">{{list1[scope.row.isTest]}}</template>
        </el-table-column>
        <el-table-column label="离职">
          <template slot-scope="scope">{{list2[scope.row.isFired]}}</template>
        </el-table-column>
       <!-- <el-table-column prop="isTest" label="是否实习" width="85"></el-table-column>

        <el-table-column prop="isFired" label="离职" width="85"></el-table-column>-->

        <el-table-column prop="createTime" label="创建时间"></el-table-column>
        <el-table-column prop="reviseTime" label="修改时间"></el-table-column>
        <el-table-column label="操作" width="180" align="center">
          <template slot-scope="scope">
            <el-button
              type="text"
              icon="el-icon-edit"
              @click="handleEdit(scope.$index, scope.row)"
            >编辑</el-button>
          </template>
        </el-table-column>
      </el-table>
      <div class="pagination">
        <el-pagination
          background
          layout="total, prev, pager, next"
          :current-page="query.pageIndex"
          :page-size="query.pageSize"
          :total="tableData.length"
          @current-change="handlePageChange"
        ></el-pagination>
      </div>
    </div>

    <!-- 编辑弹出框 -->
    <el-dialog title="编辑" :visible.sync="editVisible" width="30%">
      <el-form ref="form" :model="form" label-width="70px">
        <el-form-item label="部门">
          <el-input v-model="form.departmentId"></el-input>
        </el-form-item>
        <el-form-item label="岗位">
          <el-input v-model="form.positionId"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
                <el-button @click="editVisible = false">取 消</el-button>
                <el-button type="primary" @click="saveEdit">确 定</el-button>
            </span>
    </el-dialog>
  </div>
</template>

<script>
  import {
    reqFindAllPerson,
    reqFindAPersonById,
    reqFindPersonByName,
    reqUpdatePersonPosition
  } from '../../api/index.js'
  export default {
    data() {
      return {
        query: {
          name:'',
          id:''
        },
        tableData: [/*{
          id:1,
          userName:'张三',
          birthday:'2020-4-1',
          gender:'男',
          idCard:'42092219999999999',
          departmentId:'人事部',
          positionId:'HR',
          isTest:'否',
          isFired:'否',
          createTime:'2020-4-10',
          reviseTime:'2020-4-10'
        }*/],
        multipleSelection: [],
        delList: [],
        editVisible: false,
        pageTotal: 0,
        form: {},
        idx: -1,
        id: -1,
        list1:['正式员工','实习'],
        list2:['在职','离职'],
      };
    },
    async created () {
      const result =await reqFindAllPerson()
      console.log(result)
      this.tableData =result
    },
    methods: {
      // 触发搜索按钮
      async handleSearch () {
        const name = (this.query.name).toString()
        console.log(name)
        const result = await reqFindPersonByName({name:name});
        console.log(result)
        this.tableData = [result]
        this.query.name =''
      },
      async handleSearch2 () {
        const id1 = parseInt(this.query.id)
        console.log(id1)
        const result = await reqFindAPersonById({id: id1});
        this.tableData = [result]
        this.query.id =''
      },
      // 删除操作
      handleDelete(index, row) {
        // 二次确认删除
        this.$confirm('确定要删除吗？', '提示', {
          type: 'warning'
        })
          .then(() => {
            this.$message.success('删除成功');
            this.tableData.splice(index, 1);
          })
          .catch(() => {});
      },
      // 编辑操作
      handleEdit(index, row) {
        this.idx = index;
        this.form = row;
        console.log(this.form)
        this.editVisible = true;
      },
      // 保存编辑
      async saveEdit() {
        const userId =parseInt(this.form.id)
        const depId =parseInt(this.form.departmentId)
        const ptnId =parseInt(this.form.positionId)
        const result =await reqUpdatePersonPosition(
          {
            userId:userId,
            depId:depId,
            ptnId:ptnId
          }
        )
        if(result){
          this.editVisible = false;
          this.$message.success(`修改第 ${this.idx + 1} 行成功`);
          this.$set(this.tableData, this.idx, this.form);
        }else {
          this.$message.error(`修改第 ${this.idx + 1} 行失败`);
        }

      },
      // 分页导航
      handlePageChange(val) {
        this.$set(this.query, 'pageIndex', val);
        this.getData();
      }
    }
  };
</script>

<style scoped>
  .handle-box {
    margin-bottom: 20px;
  }

  .handle-select {
    width: 120px;
  }

  .handle-input {
    width: 300px;
    display: inline-block;
  }
  .table {
    width: 100%;
    font-size: 14px;
  }
  .red {
    color: #ff0000;
  }
  .mr10 {
    margin-right: 10px;
  }
  .table-td-thumb {
    display: block;
    margin: auto;
    width: 40px;
    height: 40px;
  }
</style>
