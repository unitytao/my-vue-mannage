<template>
  <div>
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item>
          <i class="el-icon-lx-calendar"></i> 岗位管理
        </el-breadcrumb-item>
        <el-breadcrumb-item>添加岗位</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <br />
    <div class="container">
      <div class="form-box">
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="岗位名称">
            <el-input v-model="form.gwName"></el-input>
          </el-form-item>
          <el-form-item label="所属部门">
            <el-select v-model="form.superiorId" placeholder="请选择">
              <el-option :label=item.bmName :value=item.id v-for="(item, index) in tableData" :key="index"></el-option>
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
  import {reqAddPosition,reqFindAll} from '../../api/index.js'
  export default {

    data() {
      return {
        tableData:[],
        form: {
          gwName:'',
          dplId:''
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
        const gwName=this.form.gwName.toString()
        const dplId=parseInt(this.form.dplId)
        console.log(gwName,dplId)
        console.log(gwName,dplId)
        const result =await reqAddPosition({gwName:gwName,dplId:dplId})
        console.log(result)
        this.$message.success('提交成功！');
      }
    }
  };
</script>
