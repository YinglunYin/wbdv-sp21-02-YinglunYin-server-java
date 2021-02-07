var $usernameFld, $passwordFld;
var $firstNameFld, $lastNameFld, $roleFld;
var $removeBtn, $editBtn, $createBtn, $updateBtn;
var $userRowTemplate, $tbody;
var userService = new AdminUserServiceClient();
var selectedUser = null;

var users = [
    {
        username: "Alan10", password: "1234567", firstName: "Alan",
        lastName: "Smith", role: "Admin", _id: "12344556789"
    },
    {
        username: "Alan11", password: "1234567", firstName: "Alan",
        lastName: "Smith", role: "Admin", _id: "12344556eee89"
    },
    {
        username: "Alan12", password: "1234567", firstName: "Alan",
        lastName: "Smith", role: "Admin", _id: "123445wewewew56789"
    }
];

function createUser() {
    var newUser = {
        userName: $usernameFld.val(),
        password: $passwordFld.val(),
        firstName: $firstNameFld.val(),
        lastName: $lastNameFld.val(),
        role: $roleFld.val()
    };

    userService.createUser(newUser).then(function (actualUser) {
        users.push(actualUser);
        renderUsers(users)
    })
}

function deleteUser(event) {
    var button = $(event.target);
    var index = button.attr("id");
    var id = users[index]._id;
    userService.deleteUser(id)
        .then(function (status) {
            users.splice(index, 1);
            renderUsers(users)
        })
}

function selectUser(event) {
    var id = $(event.target).attr("id");
    console.log(id);
    selectedUser = users.find(user => user._id === id);
    $usernameFld.val(selectedUser.userName);
    $passwordFld.val(selectedUser.password);
    $firstNameFld.val(selectedUser.firstName);
    $lastNameFld.val(selectedUser.lastName);
    $roleFld.val(selectedUser.role);
}

function updateUser() {
    selectedUser.userName = $usernameFld.val();
    selectedUser.password = $passwordFld.val();
    selectedUser.firstName = $firstNameFld.val();
    selectedUser.lastName = $lastNameFld.val();
    selectedUser.role = $roleFld.val();
    userService.updateUser(selectedUser._id, selectedUser)
        .then(status => {
            var index = users.findIndex(user => user._id === selectedUser._id);
            users[index] = selectedUser;
            renderUsers(users);
        })
}

function renderUsers(users) {
    $tbody.empty();

    for (var i = 0; i < users.length; i++) {
        var user = users[i];
        $tbody.append(`<tr class="wbdv-template wbdv-user">
                    <td class="wbdv-username">${user.userName}</td>
                    <td class="wbdv-password">${user.password}</td>
                    <td class="wbdv-first-name">${user.firstName}</td>
                    <td class="wbdv-last-name">${user.lastName}</td>
                    <td class="wbdv-role">${user.role}</td>
                    <td class="wbdv-actions">
                    <span class="pull-right">
                        <i class="fa-2x fa fa-times wbdv-remove" id="${i}"></i>
                        <i class="fa-2x fa fa-pencil wbdv-edit" id="${user._id}"></i>
                    </span>
                    </td>
                </tr>`)

    }
    $removeBtn = $(".wbdv-remove");
    $editBtn = $(".wbdv-edit");
    $removeBtn.click(deleteUser);
    $editBtn.click(selectUser);
}

function findAllUsers() {

} // optional - might not need this
function findUserById() {

} // optional - might not need this

function main() {
    $usernameFld = $("#usernameFld");
    $passwordFld = $("#passwordFld");
    $firstNameFld = $("#firstNameFld");
    $lastNameFld = $("#lastNameFld");
    $roleFld = $("#roleFld");
    $createBtn = $(".wbdv-create");
    $updateBtn = $(".wbdv-update");
    $userRowTemplate = $(".wbdv-template");
    $tbody = $(".wbdv-tbody");

    $createBtn.click(createUser);
    $updateBtn.click(updateUser);

    //renderUsers(users);

    userService.findAllUsers().then((function (actualUsers) {
        users = actualUsers;
        renderUsers(users)
    }))
}

$(main)