app.service('brandService', function ($http) {
    //调用后台接口
    this.reloadList = function (page, size, model) {
        return $http.post("../brand/showPageList.do?page=" + page + "&size=" + size, model);
    };

    this.findById = function (id) {
        return $http.get("../brand/findById.do?id=" + id);
    }

    this.update = function (brand) {
        return $http.post("../brand/update.do", brand);
    }

    this.insert = function (brand) {
        return $http.post("../brand/insert.do", brand);
    }

    this.delete = function (ids) {
        return $http.get("../brand/delete.do?ids=" + ids);
    }

    this.getBrandList = function () {
        return $http.get('../brand/brandListForTypeTemplate.do');
    }
})