<template>
	<div>
		<div v-if="!submitted">
			<form action method="post" id="_frmForm" name="frmForm" @submit.prevent="updateList">
				<table class="content_table">
					<colgroup>
						<col style="width:30%;" />
						<col style="width:70%;" />
					</colgroup>
					<tr>
						<th>제목</th>
						<td>
							<input data-msg="제목" type="text" name="title" id="title" v-model="vo.title"
								style="width:1500%" />
						</td>
					</tr>
					<tr>
						<th>작성자</th>
						<td>
							<input data-msg="작성자" type="text" name="name" id="name" size="30" v-model="vo.name"
								style="width:1500%" />
						</td>
					</tr>
					<tr>
						<th>내용</th>
						<td>
							<input data-msg="내용" type="text" name="memo" id="memo" size="20" v-model="vo.memo"
								style="width:1500%" />
						</td>
					</tr>
					<tr>
						<td colspan="2" style="height:50px; text-align:center;">
							<button type="submit" name="button" class="btn btn-success">수정</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
		<div class="search_box" v-else>
			<h3>
				<span style="color:blue;">성공적으로 수정하였습니다!</span>
				<br>
				<button type="submit" class="btn btn-success" @click="up">목록</button>
			</h3>
		</div>
	</div>
</template>
<script>
	import http from "C:/SSAFY2/vu/jg/src/http-common.js";
	export default {
		name: "updatelist",
		props: ["num"],
		data() {
			return {
				info: null,
				loading: true,
				errored: false,
				deps: null,
				titls: null,
				// num: 0,
				vo: {},
				submitted: false
			};
		},
		methods: {
			show_init: function () {
				http
					.get("/boardselectone/" + this.num)
					.then(response => (this.vo = response.data))
					.catch(() => {
						this.errored = true;
					})
					.finally(() => (this.loading = false));
			},
			updateList() {
				// alert("wow!");
				if (this.vo.title == "") {
					alert("제목을 입력하세요.");
					return;
				}
				if (this.vo.memo == "") {
					alert("내용를 입력하세요.");
					return;
				}
				if (this.vo.name == "") {
					alert("작성자를 입력하세요.");
					return;
				}
				http
					.put("/boardupdate", {
						num: this.num,
						name: this.vo.name,
						title: this.vo.title,
						memo: this.vo.memo,
						date: this.vo.date,
						cnt: this.vo.cnt
					})
				this.submitted = true;
			},
			up(){
				this.$router.push("/board");
			}
		},
		mounted() {
			this.show_init();
		}
	};
</script>
<style>
	.submitform {
		max-width: 300px;
		margin: auto;
	}
</style>