<template>
    <div v-html="html" class="html-Panel"></div>
</template>

<script>
    export default {
      name: "HtmlPanel",
      // 使用时请使用 :url.sync=""传值
      props:{
        url:{
          type:String,
          required: true
        }
      },
      data(){
        return{
          fullscreenLoading:false,
          html:''
        }
      },
      watch:{
        url(value){
          this.load(value)
        }
      },
      mounted() {
        this.load(this.url)
      },
      methods:{
          load(url){
            if (url && url.length > 0){
              //加载中
              this.fullscreenLoading = true
              let param ={
                accept: 'text/html, text/plain'
              }
              this.$http.get(url, param).then((response) => {
                this.fullscreenLoading = false
                // 处理HTML显示
                this.html = response.data
              }).catch(() => {
                this.fullscreenLoading = false
                this.html = '加载失败,请确认网络状态'
              })
            }
          }
      }
    }
</script>

<style scoped>
.html-Panel{
  width: 100%;
  height: 100%;
}
</style>
