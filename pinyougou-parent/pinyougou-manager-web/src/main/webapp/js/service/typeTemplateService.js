app.service('typeTemplateService', function ($http) {
    this.showPageList = function (page, size, model) {
        return $http.post('/typeTemplate/showPageList.do?page=' + page + '&size=' + size, model);
    }

    this.findByid = function (id) {
        return $http.get('/typeTemplate/findByid.do?id=' + id);
    }

    this.save = function (model) {
        return $http.post('/typeTemplate/save.do?', model);
    }
})