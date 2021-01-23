import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    mes: ""
  },
  mutations: {
    show(state, newmes) {
      state.mes += newmes;
    }
  },
  actions: {}
});