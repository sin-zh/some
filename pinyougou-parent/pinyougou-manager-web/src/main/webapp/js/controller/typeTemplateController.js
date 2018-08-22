app.controller('typeTemplateController', function ($scope, $controller, typeTemplateService, brandService, specificationService) {
    $controller('baseController', { $scope: $scope });

    $scope.model = {};
    $scope.reloadList = function () {
        typeTemplateService.showPageList($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage, $scope.model).then(
            function (response) {
                $scope.paginationConf.totalItems = response.data.total;
                $scope.list = response.data.rows;
            }, function (response) {
                alert("获取后台数据失败");
            }
        )
    }

    $scope.brandList = { data: [] };
    $scope.getBrandList = function () {
        brandService.getBrandList().then(function (response) {
            $scope.brandList = { data: response.data };
        })
    }

    $scope.specificationList = { data: [] }
    $scope.getSpecificationList = function () {
        specificationService.getSpecificationList().then(function (response) {
            $scope.specificationList = { data: response.data };
        })
    }

    $scope.addCustomAttributeItems = function () {
        $scope.entity.customAttributeItems.push({})
    }

    $scope.deleteCustomAttributeItems = function (index) {
        $scope.entity.customAttributeItems.splice(index, 1);
    }

    $scope.findByid = function (id) {
        typeTemplateService.findByid(id).then(function (response) {
            $scope.entity = response.data;
            $scope.entity.brandIds = JSON.parse(response.data.brandIds);
            $scope.entity.specIds = JSON.parse(response.data.specIds);
            $scope.entity.customAttributeItems = JSON.parse(response.data.customAttributeItems);
        })
    }

    $scope.save = function () {
        typeTemplateService.save($scope.entity).then(function (response) {
            alert(response.data.message);
            $scope.reloadList();
        })
    }


})