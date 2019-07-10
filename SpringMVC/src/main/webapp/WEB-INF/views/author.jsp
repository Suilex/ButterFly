<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title></title>
    <link rel="stylesheet" type="text/css" href="123.css" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>

 <a href="/"> <button class="btn btn-primary">Back</button> </a>
    <br>
    <br>
<button type="button" class="btn btn-success" data-toggle="modal" data-target="#exampleModal">
        Add
    </button>

    <!-- Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <div align="center"><h5 class="modal-title" id="exampleModalLabel">Add the author in the form below</h5></div>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div align="center">
                        <form style="width:300px" action = "/addauthor" method="POST">
                            <div class="form-group">
                                <input  class="form-control" name = "FirstName" placeholder="FirstName">
                            </div>
                            <div class="form-group">
                                <input  class="form-control" name = "LastName" placeholder="LastName">
                            </div>
                            <div class="form-group">
                                <input type="number" class="form-control" name = "Year" placeholder="Year">
                            </div>
                            <br>
                            <button style="width:300px" class="btn btn-success">Submit</button>
                        </form>
                        <br>
                        <a href="/author"><button style="width:300px" class="btn btn-primary">&nbsp Back &nbsp</button></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <br>
    <br>
    <div class="container">
        <h2>Full list of author:</h2>
        <br>

<table border ='1' class="table table-hover">
        <tbody>
            <tr>
                <th> Id </th>
                <th> FirstName </th>
                <th> LastName </th>
                <th> Year </th>
            </tr>
             <#list authors as author>
            <tr>
                <td> ${author.getId()} </td>
                <td> <a href= "/pageAuthor/${author.getId()}"> ${author.getFirstName()} </a> </td>
                <td> ${author.getLastName()} </td>
                <td> ${author.getYear()} </td>
                <td> <a href="/author/${author.getId()}"><button class="btn btn-danger">Delete</button></a></td>
                <td> <a href="/editAuthor/${author.getId()}"><button class="btn btn-info">Edit</button></a> </td>
            </tr>
            </#list>
        </tbody>
    </table>

</div>
</body>
</html>