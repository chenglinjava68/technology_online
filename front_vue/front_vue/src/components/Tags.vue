<template>
  <div class="tags" >
    <ul>
      <li v-for="(item,index) in tagsList">

      </li>
    </ul>
  </div>
</template>

<script>
  import { EventBus } from '../assets/js/bus';
  export default {
    name: "Tags",
    data() {
      return {
        tagsList: []
      }
    },
    methods: {

    },
  }
</script>

<style scoped>
  .tags {
    position: relative;
    height: 30px;
    overflow: hidden;
    background: #fff;
    padding-right: 120px;
    box-shadow: 0 5px 10px #ddd;
  }

  .tags ul {
    box-sizing: border-box;
    width: 100%;
    height: 100%;
  }
</style>
