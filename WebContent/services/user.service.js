(function () {
    'use strict';

    angular
        .module('app')
        .factory('UserService', UserService);

    UserService.$inject = ['$http'];
    function UserService($http) {
        var service = {};

        service.GetAllUserProfiles = GetAllUserProfiles;
        service.GetById = GetById;
        service.GetByUsername = GetByUsername;
        service.Create = Create;
        service.Update = Update;
        service.Delete = Delete;
        service.SaveUserProfile = SaveUserProfile;
        service.GetProfileByUsername = GetProfileByUsername;


        return service;

        function GetAllUserProfiles() {
            return $http.get('crewdata/data/userprofiles').then(handleUserProfiles, handleError('Error getting user profiles'));
        }

        function GetById(id) {
            return $http.get('/api/users/' + id).then(handleSuccess, handleError('Error getting user by id'));
        }

        function GetByUsername(username) {
            return $http.get('crewdata/data/getuser' + username).then(handleSuccess, handleError('Error getting user by username'));
        }
        
        function GetProfileByUsername(username, editflag) {
        	var Indata = {'username': username, 'editflag': editflag };
            return $http.post('crewdata/data/getselecteduser', Indata).then(handleUserProfiles, handleError('Error getting user profile by username'));
        }

        function Create(user) {
        	//alert(user.username);
        	user.email=user.username;
            return $http.post('crewdata/data/user', user).then(handleSuccess, handleError('Error creating user'));
        }

        function Update(user) {
            return $http.put('/api/users/' + user.id, user).then(handleSuccess, handleError('Error updating user'));
        }

        function Delete(id) {
            return $http.delete('/api/users/' + id).then(handleSuccess, handleError('Error deleting user'));
        }

        function SaveUserProfile(user) {
        	//alert("===");
        	//user.email=user.username;
            return $http.post('crewdata/data/saveuserprofile', user).then(handleSuccess, handleError('Error creating user'));
        }

        // private functions

        function handleSuccess(res) {
        	// var deferred = $q.defer();
        	// deferred.resolve(res);
        	//alert('here in sucess');
            return { success: true }; //res.data;
        }
        
        function handleUserProfiles(res) {
        	
        	//alert(res.data);
        	return res.data;
        	
        }

        function handleError(error) {
            return function () {
            	//alert('here in failure');
                return { success: false, message: error };
            };
        }
    }

})();
