var professorModulo = angular.module('professorModulo',[]);

professorModulo.controller("professoresController", function($scope, $http) {
	
	urlProfessor = 'http://localhost:8080/Projeto4Final/rest/professores';
	
	 $scope.listarProfessores = function () {
	     $http.get(urlProfessor).then(successCallback, errorCallback);
	 
	     function successCallback(response){
	         $scope.professores = response.data;
	     }
	     function errorCallback(error){
	         alert(error);
	     }
	 }
	
	$scope.selecionaprofessor = function(professorSelecionado) {
		$scope.professor = professorSelecionado;
	}

	$scope.limparCampos = function() {
		$scope.professor = "";
	}
	
	$scope.salvar = function(){
		if($scope.professor.codigo == undefined){
		
	
			$http.post(urlProfessor, $scope.professor).success(function(professor){
				//$scope.professor.push($scope.professor);
				$scope.limparCampos();
				$scope.listarProfessores();
			}).error(function(erro){
				alert(erro);
			});
			
		} else
			{
				$http.put(urlProfessor, $scope.professor).success(function(professor){
					$scope.listarProfessores();
					$scope.limparCampos();
				}).error(function(erro){
					alert(erro);
				});
			
			}
		
		
	}
	
	$scope.excluir = function() {
		if ($scope.professor.codigo == undefined) {
		} else {
			$http.delete(urlProfessor+'/'+$scope.professor.codigo).success(function () {
				 $scope.listarProfessores();
			     $scope.limparCampos();
			  }).error (function (erro) {
					alert(erro);
				});	
		}
	}
	
	//executa
	$scope.listarProfessores();
	
	
});





