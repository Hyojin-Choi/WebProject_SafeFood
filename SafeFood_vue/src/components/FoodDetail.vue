<template>
   <div class="row">
				<div class="main col-12">
					<!-- page-title start -->
					<h1 class="page-title text-center">제품 정보</h1>
					<div class="separator with-icon">
						<i class="fa fa-shopping-bag bordered"></i>
						<!-- ::after -->
					</div>
				</div>
				<!-- page-title end -->
				<div class="image-box style-3-b">
					<div class="row">
						<!-- 아메리카노 Image start-->
						<div class="col-md-6 col-lg-4 col-xl-3">
							<div class="overlay-container">
                <img :src="'/'+info.image" style = "max-width : 300px">
                <a class="overlay-link popup-img-single">
								<i class="fa fa-search-plus"> </i>
								</a>
							</div>
						</div>
						<!-- 아메리카노 Image end-->
						<div class="col-lg-8 col-xl-7 pv-30">
							<table class="table">
								<tbody>
									<tr>
										<td width="100">제품명</td>
										<td>{{info.name }}</td>
									</tr>
									<tr>
										<td width="100">제조사</td>
										<td>{{info.maker }}</td>
									</tr>
									<tr>
										<td width="100">원재료</td>
										<td>{{info.material }}</td>
									</tr>
									<tr>
										<td width="100px">알레르기 성분</td>
										<td></td>
									</tr>
								</tbody>
							</table>
							<form class="clearfix row grid-space-10">
								<div class="form-group">
									<label>Quantity</label> <input type="text" class="form-control"
										id="qnt" name="qnt" value="1">
								</div>
							</form>
							<div class="product elements-list">
								<label> </label>
								<div class="btn-group">
									<a href="#" onclick="addIntakeFood(20)"
										class="btn btn-default btn-sm"> <i class="fa fa-user pr-2">
									</i> " 추가"
									</a> <a href="#" onclick="addIntakeFood(20)"
										class="btn btn-default btn-sm"> <i class="fa fa-user pr-2">
									</i> " 찜"
									</a>
								</div>
							</div>
						</div>
					</div>
				</div>
				<h4 class="space-top">영양 정보</h4>
				<div class="row">
					<div class="col-sm-6">
						<canvas id="doughnut-graph" height="150"></canvas>
						<!-- <canvas id="doughnut-graph" height="184" style="display: block; width: 240px; height: 184px;" width="240" class="chartjs-render-monitor"> -->
						<!-- </canvas> -->
					</div>
					<div class="col-sm-6">
						<table class="table">
							<tbody>
								<tr>
									<td width="200">일일 제공량</td>
									<td>{{info.supportpereat }}</td>
								</tr>
								<tr>
									<td width="200">칼로리</td>
									<td>{{info.calory}}</td>
								</tr>
								<tr>
									<td width="200">탄수화물</td>
									<td>{{info.carbo}}</td>
								</tr>
								<tr>
									<td width="200">단백질</td>
									<td>{{info.protein}}</td>
								</tr>
								<tr>
									<td width="200">지방</td>
									<td>{{info.fat}}</td>
								</tr>
								<tr>
									<td width="200">당류</td>
									<td>{{info.sugar}}</td>
								</tr>
								<tr>
									<td width="200">나트륨</td>
									<td>{{info.natrium}}</td>
								</tr>
								<tr>
									<td width="200">콜레스테롤</td>
									<td>{{info.chole}}</td>
								</tr>
								<tr>
									<td width="200">포화 지방산</td>
									<td>{{info.fattyacid}}</td>
								</tr>
								<tr>
									<td width="200">트랜스지방</td>
									<td>{{info.transfat}}</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				<!--  main end -->
				<br /> <br />
		<div>
			<!-- <pie :data="names" /> -->
		</div>
	</div>
</template>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js">
</script>
<script>
import http from "C:/SSAFY2/vu/jg/src/http-common.js";
export default {
  name: "fooddetail",
  props: ["code"],
  data() {
    return {
      info: [],
      loading: true,
      errored: false,
      cid: "",
      food: {}
    };
  },
  methods: {
    show_init: function() {
      http
        .get("/fooddetail/" + this.code)
		.then(response => {this.info = response.data;
		this.make_chart();})
        .catch(() => {
          this.errored = true;
        })
		.finally(() => (this.loading = false));
	},
	make_chart: function() {
		var nutr_cont1 = this.info.carbo;
		var nutr_cont2 = this.info.protein;
		var nutr_cont3 = this.info.fat;
		var nutr_cont4 = this.info.sugar;
		var nutr_cont5 = this.info.natrium;
		var nutr_cont6 = this.info.chole;
		var nutr_cont7 = this.info.fattyacid;
		var nutr_cont8 = this.info.transfat;
		var ctx = document.getElementById("doughnut-graph")
								.getContext("2d");
						var myChart = new Chart(ctx, {
							type : 'doughnut',
							data : {
								labels : [ "탄수화물", "단백질", "지방", "당류",
										"나트륨", "콜레스테롤", "포화 지방산", "트렌스지방" ],
								datasets : [ {
									label : '# of Votes',
									data : [ nutr_cont1, nutr_cont2,
											nutr_cont3, nutr_cont4, nutr_cont5,
											nutr_cont6, nutr_cont7, nutr_cont8],
									backgroundColor : [
											'rgba(255, 99, 132, 0.2)',
											'rgba(54, 162, 235, 0.2)',
											'rgba(255, 206, 86, 0.2)',
											'rgba(75, 192, 192, 0.2)',
											'rgba(153, 102, 255, 0.2)',
											'rgba(255, 159, 64, 0.2)',
											'rgba(255, 153, 255, 0.2)',
											'rgba(102, 0, 153, 0.2)',
											'rgba(51, 0, 0, 0.2)' ],
									borderColor : [ 'rgba(255, 99, 132, 1)',
											'rgba(54, 162, 235, 1)',
											'rgba(255, 206, 86, 1)',
											'rgba(75, 192, 192, 1)',
											'rgba(153, 102, 255, 1)',
											'rgba(255, 159, 64, 1)',
											'rgba(255, 153, 255, 1)',
											'rgba(102, 0, 153, 1)',
											'rgba(51, 0, 0, 1)' ],
									borderWidth : 1
								} ]
							},
							options : {
								scales : {
									yAxes : [ {
										ticks : {
											beginAtZero : true
										}
									} ]
								}
							}
						});
    },
  },
  mounted() {
	this.show_init();
  }
};
</script>
<style>
.arc text {
  font: 15px sans-serif;
  text-anchor: middle;
 color: crimson;
}
.arc path {
  stroke: #fff;
}
.arc2 text {
  font: 15px sans-serif;
  text-anchor: middle;
  color: crimson;
}
.arc2 path {
  stroke: #fff;
}
.range-input {
  display: flex;
  align-items: center;
  justify-content: center;
  margin-bottom: 10px;
}
input {
  margin-left: 10px;
}
.row{
	margin-left:0px;
	margin-right:0px;
}
</style>