//设置控制器
   		app.controller('brandController',function($scope,$controller,brandService){
   			$controller("baseController",{$scope:$scope});    
   			$scope.findAll=function(){
   				brandService.findAll().success(
   	   					function(response){
   	   	   					$scope.list=response;
   	   	   				}		
   	   			);
   			}
   			
   			
   			$scope.findByPage=function(page,size){
   	   			//设置分页查询
   	   	   			brandService.findByPage(page,size).success(
   	   	   				function(response){
   	   	   					$scope.list=response.rowsList;
   	   	   					//更新共记录数
   	   	   					$scope.paginationConf.totalItems=response.total;
   	   	   				}
   	   	   			);
   	   	   	}
   			
   			$scope.save=function(){
   				var obj;
   				if($scope.entity.id){
   					obj=brandService.update($scope.entity)
   				}else{
   					obj=brandService.save($scope.entity)
   				}
   				obj.success(
   					function(response){
   						if(response.success){
   							$scope.reloadList();//重新加载
   						}else{
   							alert(response.message);
   						}
   					}		
   				);
   			}
   			
   			
   			$scope.findOne=function(id){
   	   			//设置分页查询
   	   	   			brandService.findOne(id).success(
   	   	   				function(response){
   	   	   					$scope.entity=response;
   	   	   				}
   	   	   			);
   	   	   	}
   		
   			
   			
   			
   			$scope.dele=function(){
   	   			//设置分页查询
   	   	   			brandService.dele($scope.selectIds).success(
	   	   	   			function(response){
			   	   	   		if(response.success){
								$scope.reloadList();//重新加载
							}else{
								alert(response.message);
							}
	   	   	   			}
   	   	   			);
   	   	   	}
   			
   			$scope.searchEntity={};
   			$scope.search=function(page,size){
   				brandService.search(page,size,$scope.searchEntity).success(
	   	   				function(response){
	   	   					$scope.list=response.rowsList;
	   	   					//更新共记录数
	   	   					$scope.paginationConf.totalItems=response.total;
	   	   				}
	   	   			);
   			}
   			
   		});