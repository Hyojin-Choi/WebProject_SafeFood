import Vue from "vue";
import Router from "vue-router";
import MainList from "./components/MainList.vue";
import board from "./components/Board.vue";
import boardselectone from "./components/BoardDetail.vue"; //selectone
import boardupdate from "./components/BoardUpdate.vue";
import boardinsert from "./components/BoardAdd.vue";
import fooddetail from "./components/FoodDetail.vue";
import foodlist from "./components/FoodList.vue";
import boarddetail from "./components/BoardUpdate.vue";
import signup from "./components/signup.vue";
import searchlist from "./components/SearchList.vue";
Vue.use(Router);

export default new Router({
  mode: "history",
  routes: [
    {
      path: "/",
      name: "MainList",
      alias: "/MainList",
      component: MainList
    },
    {
      path: "/",
      name: "boarddetail",
      alias: "/boarddetail",
      component: boarddetail
    },
    {
      path: "/board",
      name: "board",
      component: board
    },
    {
      path: "/searchlist/상품명/:name",
      name: "searchlist",
      props: true,
      component: searchlist
    },
    {
      path: "/boardselectone",
      name: "boardselectone",
      component: boardselectone,
      props: true,
    },
    {
      path: "/boardupdate/:num",
      name: "boardupdate",
      component: boardupdate,
      props: true,
    },
    {
      path: "/boardinsert",
      name: "boardinsert",
      component: boardinsert
    },
    {
      path: "/fooddetail/:code",
      name: "fooddetail",
      props: true,
      component: fooddetail
    },
    {
      path: "/foodlist",
      name: "foodlist",
      component: foodlist
    },
    {
      path: "/signup",
      name: "signup",
      component: signup
    }

  ]
});