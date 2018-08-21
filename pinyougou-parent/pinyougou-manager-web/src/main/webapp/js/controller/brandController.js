app.controller('brandController', function ($scope, $controller, brandService) {
    //继承baseController
    $controller('baseController', { $scope: $scope });
    //查询条件置空
    $scope.model = {};

    //带条件的列表展示
    $scope.reloadList = function () {
        brandService.reloadList($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage, $scope.model).then(function (response) {
            //成功返回值为{total:int,rows:List<Brand>}
            $scope.paginationConf.totalItems = response.data.total;
            $scope.list = response.data.rows;
        }, function () {
            alert("获取后台数据失败");
        })
    };

    //点击修改,查询对象
    $scope.edit = function (id) {
        brandService.findById(id).then(function (response) {
            $scope.entity = response.data;
        }, function () {
            alert("获取后台数据失败");
        })
    }

    //新增/修改
    $scope.save = function () {
        if ($scope.entity.id != null) {
            //修改
            brandService.update($scope.entity).then(function (response) {
                alert("修改成功");
                $scope.reloadList();
            }, function () {
                alert("修改失败");
            })
        } else {
            //新增
            brandService.insert($scope.entity).then(function (response) {
                alert("保存成功");
                $scope.reloadList();
            }, function () {
                alert("保存失败");
            })
        }

    }

    $scope.selectedId = [];
    //删除
    $scope.dele = function () {
        brandService.delete($scope.selectedId).then(function (response) {
            alert("删除成功");
            $scope.reloadList();
        }, function () {
            alert("删除失败");
        })
    }

})