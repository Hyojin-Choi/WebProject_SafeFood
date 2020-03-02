<template>
	<div id="app">
		<nav class="navbar navbar-inverse">
			<ul class="nav navbar-nav navbar-right">
			</ul>
			<!-- Single button -->
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" role="button"
						aria-expanded="false" v-show="!this.$store.state.isLogin">Login<span class="caret"></span>
					</a>
					<ul class="dropdown-menu" role="menu">
						<li>
							<div class="row">
								<div class="col-md-12">
									<form class="form" role="form" method="post" action="#" accept-charset="UTF-8"
										v-on:submit.prevent id="loginnav">
										<div class="form-group">
											아 이 디<input type="text" class="form-control" id="rid" v-model="id"
												name="rid" placeholder="ID" required>
										</div>
										<div class="form-group">
											비 밀 번 호 <label class="sr-only" for="exampleInputPassword2">Password</label>
											<input type="password" class="form-control" id="rpw" v-model="pw" name="rpw"
												placeholder="Password" required>
											<div class="form-group" style="margin: 10px">
												<button class="btn btn-primary btn-block" @click="login">로그인</button>
											</div>
											<div class="help-block text-right">
												<button class="btn btn-primary btn-block">비밀번호 찾기</button>
											</div>
											<div class="bottom text-center" style="font-size: large">
												<a @click="goJoin"><b>Join Us</b></a>
											</div>
										</div>
									</form>
								</div>
							</div>
						</li>
					</ul>
				</li>
			</ul>

			<div class="form-group" style="margin: 10px" align="right">
				<button class="btn btn-primary btn-block" @click="logout" v-show="this.$store.state.isLogin"
					style="width:80px; height:30px; ">로그아웃</button>
			</div>
		</nav>
		<nav class="navbar navbar-default navbar" role="navigation">
			<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<router-link to="/"> <img src="./assets/header-logo.jpg"></router-link>
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
						data-target="#bs-example-navbar-collapse-1">
					</button>
					<a class="navbar-brand" href="#"></a>
				</div>
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav" style="color: red">
						<li>
							<router-link to="/board">공지사항</router-link>
						</li>
						<li>
							<router-link to="/foodlist">상품 정보</router-link>
						</li>
						<li><a href="#">베스트 섭취 정보</a></li>
						<li><a href="#">내 섭취 정보</a></li>
						<li><a href="#">예상 섭취 정보</a></li>

					</ul>
					<form action="searchname" method="post" class="navbar-form navbar-right" role="search"
						@submit.prevent="search(searchname)">
						<div class="form-group">
							<input id="searchbar" type="text" name="name" class="form-control" placeholder="Search"
								v-model="searchname">
						</div>
						<button type="submit" class="btn btn-default" @submit.prevent="search(searchname)">
							<span class="glyphicon glyphicon-search"></span>
						</button>
					</form>
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
								aria-expanded="false">인기검색어
								<span class="caret"></span>
							</a>
							<ul class="dropdown-menu" role="menu" style="background-color : white " id="wordlist">
							</ul>
						</li>
					</ul>
				</div>
			</div>

			<!-- /.navbar-collapse -->
			<!-- /.container-fluid -->
		</nav>

		<div class="jumbotron">
			<h1>WHAT WE PROVIDE</h1>
			<hr>
			건강한 삶을 위한 먹거리 프로젝트
		</div>
		<div>
			<router-view />
		</div>
		<div class="footer" style="background-color: #F8F8FF">
			<div class="container">
				<div class="footer-inner">
					<div class="row">
						<div class="col-lg-10">
							<div class="footer-content">
								<br />
								<h2 class="title">Find Us</h2>
								<hr>
								<div class="separator-2"></div>
								<ul class="list-icons" style="list-style: none;">
									<li style="opacity: 0.6"><img src="/img/위치.png" width="20px"> (SSAFY) 서울시 강남구 테헤란로
										멀티스퀘어</li>
									<li style="opacity: 0.6"><img src="/img/전화.png" width="20px"> 1544-9001</li>
									<li style="opacity: 0.6">
										<a href="#"><img src="/img/이메일.png" width="20px"> admin@ssafy.com</a>
									</li>
								</ul>
								<br />
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="subfooter" style="background-color: #F5F5F5">
			<div class="container">
				<div class="subfooter-inner">
					<div class="row">
						<div class="col-md-12">
							<br />
							<p class="text-center" style="opacity: 0.6">Copyright by
								SSAFY. All rights reserved.</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
	import http from "C:/SSAFY2/vu/jg/src/http-common.js";
	export default {
		name: "MainList",
		data() {
			return {
				info: [],
				id: '',
				pw: ''
			}
		},
		components: {},
		computed: {},
		methods: {
			getImgUrl(pic) {
				return require('./assets/' + pic)
			},
			show_detail: function (code) {
				alert(code + "상세보기");
				this.$router.push("/fooddetail/" + code);
			},
			search: function (name) {
				alert(name + "로 검색했습니다.")
				this.$router.push("/searchlist/상품명/" + name);
			},
			login() {
				http
					.get('/Login/' + this.id + "&" + this.pw)
					.then(response => {
						if (response.data) {
							alert("로그인 성공");
							this.$store.state.isLoginId = this.id;
							this.$store.state.isLogin = true;
						} else {
							alert("로그인 실패");
						}
					})
					.catch(() => {
						this.errored = true;
					})
					.finally(() => (this.loading = false));
			},
			logout() {
				this.$store.state.isLoginId = '';
				this.$store.state.isLogin = false;
			},
			goJoin: function () {
				// alert("join");
				this.$router.push("/signup");
			},
		},
		mounted() {
			http
				.get('/searchProduct/상품명/' + this.name)
				.then(response => (this.info = response.data))
				.catch(() => {
					this.errored = true
				})
				.finally(() => this.loading = false);
		}
	};
</script>

<style>
	/* #app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
} */
</style>