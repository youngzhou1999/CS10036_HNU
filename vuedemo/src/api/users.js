import HttpRequest from '@/axios/api.request'


export const UsersQryAction = () => {
    //console.log("get")
    return HttpRequest.request({
        url: 'users/',
        method: 'get'
    })
}

export const UsersAddAction = (parameter) => {
    return HttpRequest.request({
        url: 'users/',
        method: 'post',
        params: parameter
    })
}

export const UsersUpdateAction = (parameter) => {
    return HttpRequest.request({
        url: 'users/',
        method: 'put',
        params: parameter
    })
}

export const UsersDelAction = (parameter) => {
    return HttpRequest.request({
        url: 'users/',
        method: 'delete',
        params: {
            username: parameter
        }
    })
}
