<template>
  <div>
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item>
          <i class="el-icon-lx-calendar"></i> 部门管理
        </el-breadcrumb-item>
        <el-breadcrumb-item>添加部门</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <br />
    <div class="container">
      <div class="form-box">
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="部门名称">
            <el-input v-model="form.bmName"></el-input>
          </el-form-item>
          <el-form-item label="上级部门">
            <el-select v-model="form.superiorId" placeholder="请选择">
              <el-option :label=item.bmName :value=item.id v-for="(item, index) in tableData" :key="index"></el-option>
              <!--<el-option key="xtc" label="财务" value="2"></el-option>
              <el-option key="53" label="保洁" value="3"></el-option>
              <el-option key="1" label="无" value="0"></el-option>-->
            </el-select>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="onSubmit()">表单提交</el-button>
            <el-button>取消</el-button>
          </el-form-item>
        </el-form>
      </div>
    </div>
  </div>
</template>

<script>
  import {reqAddDepart,reqFindAll} from '../../api/index.js'
  export default {

    data() {
      return {
        tableData:[],
        form: {
        bmName:'',
        superiorId:''
        }
      };
    },
    async created () {
      const result =await reqFindAll()
      console.log(result)
      this.tableData =result
    },
    methods: {
      async onSubmit() {
       const bmName=this.form.bmName
       const superiorId= parseInt(this.form.superiorId)
        console.log(bmName,superiorId)
        const result =await reqAddDepart({bmName:bmName,superiorId:superiorId})
        console.log(result)
        this.$message.success('提交成功！');
      }
    }
  };
</script>
