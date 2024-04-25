<script lang="ts" setup>
import { ref } from 'vue'
import { Menu as IconMenu, Message, Setting } from '@element-plus/icons-vue'

const item = {
    empId: '001',
    empName: '张三',
    emAaddress: '上海市普陀区金沙江路 1518 弄'
}
const tableData = ref(Array.from({ length: 20 }).fill(item))
</script>

<template>
    <!-- 布局容器 -->
    <div class="common-layout">
    <el-container>
    <el-header>Header</el-header>
    <el-container>
        <el-aside width="200px">Aside</el-aside>
        <el-main>Main</el-main>
      
      <el-main>
        <el-scrollbar>
          <el-table :data="tableData">
            <el-table-column prop="empId" label="Id" width="140" />
            <el-table-column prop="empName" label="Name" width="120" />
            <el-table-column prop="emAaddress" label="Address" />
          </el-table>
        </el-scrollbar>
      </el-main>
    
<!-- 分页条 -->
        <el-pagination
            :page-size="500"
            :pager-count="5"
            layout="prev, pager, next"
            :total="1000"
        />

    </el-container>
  </el-container>
</template>



<style scoped>
.layout-container-demo .el-header {
  position: relative;
  background-color: var(--el-color-primary-light-7);
  color: var(--el-text-color-primary);
}
.layout-container-demo .el-aside {
  color: var(--el-text-color-primary);
  background: var(--el-color-primary-light-8);
}
.layout-container-demo .el-menu {
  border-right: none;
}
.layout-container-demo .el-main {
  padding: 0;
}
.layout-container-demo .toolbar {
  display: inline-flex;
  align-items: center;
  justify-content: center;
  height: 100%;
  right: 20px;
}
</style>