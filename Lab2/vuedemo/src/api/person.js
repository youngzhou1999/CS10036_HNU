import HttpRequest from '@/axios/api.request'


export const PersonQryAction = () => {
    return HttpRequest.request({
      url: 'person/',
      method: 'get'
    })
}

export const PersonAddAction = (parameter) => {
    return HttpRequest.request({
        url: 'person/',
        method: 'post',
        params: parameter
    })
}

export const PersonUpdateAction = (parameter) => {
    return HttpRequest.request({
        url: 'person/',
        method: 'put',
        params: parameter
    })
}

export const PersonDelAction = (parameter) => {
    return HttpRequest.request({
        url: 'person/',
        method: 'delete',
        params: {
            username: parameter
        }
    })
}
