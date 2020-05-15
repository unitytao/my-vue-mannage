<template>
  <div>
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item>
          <i class="el-icon-lx-cascades"></i> 岗位查询
        </el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="container">
      <div class="handle-box">
        <el-input v-model="query.name" placeholder="岗位名称" class="handle-input mr10"></el-input>
        <el-button type="primary" icon="el-icon-search" @click="handleSearch2()">搜索</el-button>
        <el-input v-model="query.id" placeholder="岗位ID" class="handle-input mr10"></el-input>
        <el-button type="primary" icon="el-icon-search" @click="handleSearch()">搜索</el-button>
      </div>
      <el-table
        :data="tableData"
        border
        class="table"
        ref="multipleTable"
        header-cell-class-name="table-header"
      >
        <el-table-column prop="id" label="ID" width="55" align="center"></el-table-column>
        <el-table-column prop="gwName" label="岗位名称"></el-table-column>
        <el-table-column label="所属部门" align="center">
          <template   slot-scope="scope">
            {{workList[scope.row.departmentId]}}
          </template>
        </el-table-column>
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
          @current-change="handlePageChange"
        ></el-pagination>
      </div>
    </div>

    <!-- 编辑弹出框 -->
    <el-dialog title="编辑" :visible.sync="editVisible" width="40%">
      <el-form ref="form" :model="form" label-width="70px">
        <el-form-item label="岗位名称">
          <el-input v-model="form.gwName"></el-input>
        </el-form-item>
        <el-form-item label="所属部门">
          <el-input v-model="form.departmentId"></el-input>
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
  import {reqFindAllWork,reqDelGWById,reqUpdatePosition,reqSelectByIdJob,reqSelectByNameJob} from '../../api/index.js'
  export default {
    data() {
      return {
        query: {
          name:'',
          id:''
        },
        tableData: [],
        multipleSelection: [],
        delList: [],
        editVisible: false,
        pageTotal: 0,
        form: {},
        idx: -1,
        id: -1,
        workList: ['无','管理','财务','保洁']
      };
    },
    async created () {
      const result =await reqFindAllWork()
      console.log(result)
      this.tableData =result
    },
    methods: {
      // 触发搜索按钮
      async handleSearch () {
        const id1 = parseInt(this.query.id)
        const result = await reqSelectByIdJob({id: id1});
        this.tableData = [result]
      },
      async handleSearch2 () {
        const name = (this.query.name).toString()
        const result = await reqSelectByNameJob({name: name});
        console.log(result)
        this.tableData = [result]
      },
      // 删除操作
      async handleDelete (idx, row) {
        const id = parseInt(row.id)
        console.log(id)
        const result = await reqDelGWById({id: id})
        console.log(result)
        this.$message.success('删除成功');
        this.tableData.splice(idx, 1);
      },
      // 编辑操作
      handleEdit(index, row) {
        this.idx = index;
        this.form = row;
        this.editVisible = true;
      },
      // 保存编辑
      async saveEdit () {
        const id =parseInt(this.form.id)
        const gwName =this.form.gwName.toString()
        const depId =parseInt(this.form.departmentId)
        console.log(depId)
        const result =await reqUpdatePosition(
          {
            id:id,
            gwName:gwName,
            depId:depId
          })
        console.log(result)
        this.editVisible = false;
        this.$message.success(`修改第 ${this.idx + 1} 行成功`);
        this.$set(this.tableData, this.idx, this.form);
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
