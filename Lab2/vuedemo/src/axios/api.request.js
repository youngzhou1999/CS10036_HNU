import axios from "axios"
import config from './index'
const baseUrl = process.env.NODE_ENV === 'development' ? config.baseUrl.dev : config.baseUrl.pro

const HttpRequest = axios.create({
    baseURL: baseUrl,  // api的base_url
    timeout: 5000,  // 请求超时时间
    // withCredentials: true,
    // headers: {
    //     'Access-Control-Allow-Origin': '*'
    // }
});
export default HttpRequest