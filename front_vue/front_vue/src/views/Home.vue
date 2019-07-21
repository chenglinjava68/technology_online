<template>
  <div class="home-container">
    <vHeader></vHeader>
    <vSideBar></vSideBar>
  </div>
</template>

<script>
  import vHeader from "./Header.vue"
  import vSideBar from './SideBar.vue';
  export default {
    name: "Home",
    components:{
      vHeader,vSideBar,
    },
  }
</script>

<style scoped>

</style>
