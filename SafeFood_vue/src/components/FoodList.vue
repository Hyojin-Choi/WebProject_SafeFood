<template>
    <div style="margin-left: 200px">
		<table id="content" style="width: 90%; margin: 0 auto">
            <!-- <c:forEach var="food" items="${foodlist }"> -->
				<tr v-for="food in foods" :key="food.num" style='margin-left: 200px'>
					<td>
						<img  @click="show_detail(food.code)"
							width='180px' :src=getImgUrl(food.image)
							class='btn btn-gray-transparent btn-animated btn-sm'>
							<i class='pl-10 fa fa-arrow-right'></i>
						<p style='font-size: 18px; opacity: 0.7' v-html="food.name"></p> <span
						class='glyphicon glyphicon-calendar'> Feb, 2017 </span>&emsp; <span
						class='glyphicon glyphicon-tag'>Web Design</span><br />
						<hr>
						<p style='opacity: 0.6' v-html="food.material"></p>
						<button class='btn btn-sm btn-info' type='button'>
							<img width='20px' src=''>추가
						</button>
						<button class='btn btn-sm btn-info' type='button'>
							<img width='20px' src=''>찜

						</button></td>
				</tr>

			<!-- </c:forEach> -->

		</table>
	</div>
</template>
<script>
import http from "C:/SSAFY2/vu/jg/src/http-common.js";
export default {
  name: "FoodList",
  data () {
        return {
		loading: true,
		errored: false ,
		foods:[]
        }//return
  },
  components: {
	},
  computed: {
	},
  methods: {
	getImgUrl(pic) {
    return require('../assets/'+pic)
  },
  show_detail: function(code) {
      alert(code + "상세보기");
      this.$router.push("/fooddetail/" + code);
	}
  },
  mounted () {
    http
      .get('/productInfo')
      .then(response => (this.foods = response.data))
      .catch(() => {
        this.errored = true
      })
      .finally(() => this.loading = false);
  }
};
</script>