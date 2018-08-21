app.service('specificationService', function ($http) {
    this.reloadList = function (page, size, model) {
        return $http.post('/specification/showPageList.do?page=' + page + '&size=' + size, model);
    }
    this.insertSpecificationWithSpecificationOptions = function (model) {
        return $http.post('/specification/insertSpecificationWithSpecificationOptions.do', model);
    }
    this.findByid = function (id) {
        return $http.get('/specification/findByid.do?id=' + id);
    }
    this.updateSpecificationWithSpecificationOptions = function (model) {
        return $http.post('/specification/updateSpecificationWithSpecificationOptions.do', model);
    }
    this.deleteSpecificationWithSpecificationOptionsByids = function (ids) {
        return $http.get('/specification/deleteSpecificationWithSpecificationOptionsByids.do?ids=' + ids);
    }
})