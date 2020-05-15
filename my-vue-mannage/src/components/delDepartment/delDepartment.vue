<template>
  <div>
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item>
          <i class="el-icon-lx-cascades"></i> 部门查询
        </el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="container">
      <div class="handle-box">
        <el-input v-model="query.bmName" placeholder="部门名称" class="handle-input mr10"></el-input>
        <el-button type="primary" icon="el-icon-search" @click="handleSearch2()">名称搜索</el-button>
        <el-input v-model="query.id" placeholder="部门ID" class="handle-input mr10"></el-input>
        <el-button type="primary" icon="el-icon-search" @click="handleSearch">ID搜索</el-button>
        <el-button type="primary" icon="el-icon-search" @click="handleSearch3()">查询所有</el-button>

      </div>
      <el-table
        :data="tableData"
        border
        class="table"
        ref="multipleTable"
        header-cell-class-name="table-header"
      >
        <el-table-column prop="id" label="ID" width="55" align="center"></el-table-column>
        <el-table-column prop="bmName" label="部门名称"></el-table-column>
        <el-table-column prop="superiorId" label="上级部门"></el-table-column>
        <el-table-column prop="createTime" label="创建时间"></el-table-column>
        <el-table-column prop="reviseTime" label="修改时间"></el-table-column>
        <el-table-column label="操作" width="180" align="center">
          <template slot-scope="scope">
            <el-button
              type="text"
              icon="el-icon-edit"
              @click="handleEdit(scope.$index, scope.row)"
            >编辑</el-button>
            <el-button
              type="text"
              icon="el-icon-delete"
              class="red"
              @click="handleDelete(scope.$index, scope.row)"
            >删除</el-button>
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
        ></el-pagination>
      </div>
    </div>

    <!-- 编辑弹出框 -->
    <el-dialog title="编辑" :visible.sync="editVisible" width="30%">
      <el-form ref="form" :model="form" label-width="70px">
        <el-form-item label="部门名称">
          <el-input v-model="form.bmName"></el-input>
        </el-form-item>
        <el-form-item label="上级部门">
          <el-input v-model="form.superiorId"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
                <el-button @click="editVisible = false">取 消</el-button>
                <el-button type="primary" @click="saveEdit(query.id)">确 定</el-button>
            </span>
    </el-dialog>
  </div>
</template>

<script>
  import {reqSelectByName,reqDelById,reqUpdateDepartment} from '../../api/index.js'
  import {reqSelectById,reqFindAll} from '../../api/index.js'
  export default {
    data () {
      return {
        query: {
          id: '',
          bmName: '',
          superiorId: '',
          createTime: '',
          reviseTime: ''
        },
        tableData: [],
        multipleSelection: [],
        delList: [],
        editVisible: false,
        pageTotal: 0,
        form: {},
        idx: -1,
        id: -1,
      };
    },
    async created () {
      const result =await reqFindAll()
      console.log(result)
      this.tableData =result
    },
    methods: {
      // 触发搜索按钮
      async handleSearch () {
        const id1 = parseInt(this.query.id)
        const result = await reqSelectById({id: id1});
        this.tableData = [result]
      },
      async handleSearch2 () {
        const bmName = (this.query.bmName).toString()
        const result = await reqSelectByName({bmName: bmName});
        console.log(result)
        this.tableData = [result]
      },
      async handleSearch3 () {
        const result = await reqFindAll();
        console.log(result)
        this.tableData = result
      },
      // 删除操作
      async handleDelete (idx, row) {
        const id = parseInt(row.id)
        console.log(id)
        const result = await reqDelById({id: id})
        console.log(result)
        this.$message.success('删除成功');
        this.tableData.splice(idx, 1);
      },
      // 编辑操作
       handleEdit (index, row) {
        this.idx = index;
        this.form = row;
        this.editVisible = true;
      },
      // 保存编辑
      async saveEdit () {
        const id =parseInt(this.form.id)
        const bmName =this.form.bmName.toString()
        const superiorId =parseInt(this.form.superiorId)
        const result =await reqUpdateDepartment(
          {
            id:id,
            bmName:bmName,
            superiorId:superiorId
          })
        console.log(result)
        this.editVisible = false;
        this.$message.success(`修改第 ${this.idx + 1} 行成功`);
        this.$set(this.tableData, this.idx, this.form);
      },
      // 分页导航
      handlePageChange (val) {
        this.$set(this.query, 'pageIndex', val);
        this.getData();
      }
      }
  }
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
