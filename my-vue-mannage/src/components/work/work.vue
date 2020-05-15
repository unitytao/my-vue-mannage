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
        <el-table-column prop="createTime" label="创建时间"></el-table-column>
        <el-table-column prop="reviseTime" label="修改时间"></el-table-column>
        <el-table-column label="操作" width="180" align="center">
          <template slot-scope="scope">
            <el-button
              type="text"
              icon="el-icon-edit"
              @click="handleEdit(scope.$index, scope.row)"
            >转正</el-button>
            <el-button
              type="text"
              icon="el-icon-delete"
              class="red"
              @click="setFired(scope.$index, scope.row)"
            >离职</el-button>
          </template>
        </el-table-column>
      </el-table>
      <div class="pagination">
        <el-pagination
          background
          layout="total, prev, pager, next"
          :current-page="1"
          :page-size="10"
          :total="tableData.length"
          @current-change="handlePageChange"
        ></el-pagination>
      </div>
    </div>
  </div>
</template>

<script>
  import {
    reqFindAllPerson,
    reqFindAPersonById,
    reqFindPersonByName,
    reqSetTestOver,
    reqSetFired
  } from '../../api/index.js'
  export default {
    data() {
      return {
        query: {
          name:'',
          id:''
        },
        list1:['正式员工','实习'],
        list2:['在职','离职'],
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
        id: -1
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
      async handleEdit(idx,row){
        const id = row.id
        const result =await reqSetTestOver({id:id})
        console.log(result)
        this.$message('操作成功')
        this.tableData =result
        this.$router.go(0);
      },
      async setFired(idx,row){
        const id = row.id
        const result =await reqSetFired({id:id})
        console.log(result)
        this.$message('操作成功')
        this.tableData =result
        this.$router.go(0);
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
