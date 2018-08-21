app.controller('specificationController', function ($scope, $controller, specificationService) {
    $controller('baseController', { $scope: $scope });
    $scope.model = {};
    //带条件的列表展示
    $scope.reloadList = function () {
        specificationService.reloadList($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage, $scope.model).then(function (response) {
            //成功返回值为{total:int,rows:List<Brand>}
            $scope.paginationConf.totalItems = response.data.total;
            $scope.list = response.data.rows;
        }, function () {
            alert("获取后台数据失败");
        })
    };


    //新增规格选项
    $scope.addSpecificationOption = function () {
        $scope.entity.specificationOptions.push({});
    }
    //删除规格选择
    $scope.deleSpecificationOption = function (index) {
        $scope.entity.specificationOptions.splice(index, 1);
    }

    //回显
    $scope.findByid = function (id) {
        $scope.entity = { specification: {}, specificationOptions: [] };
        specificationService.findByid(id).then(function (response) {
            $scope.entity = response.data;
        }, function () {
            alert("获取后台数据失败");
        })
    }

    //保存
    $scope.save = function () {
        if ($scope.entity.specification.id == null) {
            specificationService.insertSpecificationWithSpecificationOptions($scope.entity).then(function (response) {
                alert("ok");
                $scope.reloadList();
            }, function () {
                alert("T_T再试一次把");
            })
        } else {
            specificationService.updateSpecificationWithSpecificationOptions($scope.entity).then(function (response) {
                alert("ok");
                $scope.reloadList();
            }, function () {
                alert("T_T再试一次把");
            })
        }
    }
    $scope.selectedId = [];

    //批量删除
    $scope.dele = function () {

        specificationService.deleteSpecificationWithSpecificationOptionsByids($scope.selectedId).then(function (response) {
            alert("ok");
            $scope.reloadList();
        }, function () {
            alert("T_T再试一次把");
        })
    }

})