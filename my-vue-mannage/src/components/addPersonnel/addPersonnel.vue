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
          <el-form-item label="姓名">
            <el-col :span="5">
            <el-input v-model="form.userName"></el-input>
            </el-col>
          </el-form-item>
          <el-form-item label="所属部门">
            <el-select v-model="form.departmentId" placeholder="请选择">
              <el-option :label=item.bmName :value=item.id v-for="(item, index) in tableData" :key="index"></el-option>
            </el-select>
          <!--<el-select v-model="form.depId" placeholder="请选择">
            <el-option key="bbk" label="管理" value="1"></el-option>
            <el-option key="xtc" label="财务" value="2"></el-option>
            <el-option key="2" label="保洁" value="3"></el-option>
            <el-option key="0" label="无" value="0"></el-option>
          </el-select>-->
        </el-form-item>
          <el-form-item label="岗位">
            <el-select v-model="form.superiorId" placeholder="请选择">
              <el-option key="bbk" label="扫地阿姨" value="1"></el-option>
              <el-option key="xtc" label="会计" value="2"></el-option>
              <el-option key="5" label="程序员" value="3"></el-option>
              <el-option key="1" label="后端" value="0"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="性别">
          <el-select v-model="form.gender" placeholder="性别">
            <el-option key="bbk" label="男" value="男"></el-option>
            <el-option key="xtc" label="女" value="女"></el-option>
          </el-select>
          </el-form-item>
          <el-form-item label="身份证号">
            <el-col :span="8">
              <el-input v-model="form.idCard"></el-input>
            </el-col>
          </el-form-item>
          <el-form-item label="出生日期">
            <el-col :span="10">
              <el-date-picker
                type="date"
                placeholder="选择日期"
                v-model="form.birthday"
                value-format="yyyy-MM-dd"
                style="width: 100%;"
              ></el-date-picker>
            </el-col>
          </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="onSubmit">添加</el-button>
            <el-button>取消</el-button>
          </el-form-item>
        </el-form>
      </div>
    </div>
  </div>
</template>

<script>
  import {reqAddUser,reqFindAll} from '../../api/index'
  export default {
    data() {
      return {
        form: {},
        tableData:[],
      };
    },
    async created () {
      const result =await reqFindAll()
      console.log(result)
      this.tableData =result
    },
    methods: {
      async onSubmit() {
        const name =this.form.userName
        const gender =this.form.gender.toString()
        const birthday =this.form.birthday
        const idCard =this.form.idCard
        const depId =this.form.departmentId
        const  psnId=this.form.superiorId
       const reasult =await reqAddUser({
         name:name,
         gender:gender,
         birthday:birthday,
         idCard:idCard.toString(),
         depId:depId,
         psnId:psnId
       })
        console.log(reasult)
        this.$message.success('提交成功！');
      }
    }
  };
</script>
