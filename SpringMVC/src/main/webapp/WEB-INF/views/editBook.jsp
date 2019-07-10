<!DOCTYPE html>
<html lang="en">
<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

  <title></title>
</head>
<body>

  <br>
  <br>
  <div align="center"><h2>Edit the book in the form below</h2>
    <br>
    <br>
    <br>
    <form style="width:300px" method = "POST">
      <div class="form-group">
        Id <input  class="form-control" readonly name = "Id" value= ${book.getId()}>
      </div>
      <div class="form-group">
        Name <input  class="form-control" name = "Name" value= ${book.getName()}>
      </div>
      <div class="form-group">
        Description <input  class="form-control" name = "Description" value= ${book.getDescription()}>
      </div>
      <div class="form-group">
        Published <input  class="form-control" name = "Published" value= ${book.getPublished()}>
      </div>
      <div class="form-group">
        Year <input class="form-control" name = "Year" value= ${book.getYear()}>
      </div>
      <div class="form-group">
          Already added <select class="form-control">
          <#list authorList as author>
            <option>${author.getFirstName()}</option>
            </#list>
          </select>
      </div>
      <div class="form-group">
            Add <select class="form-control" name = "authorId">
            <option value = "0">No add</option>
            <#list authors as item>
              <option value = ${item.getId()}>${item.getFirstName()}</option>
              </#list>
            </select>
        </div>
      <br>
      <button style="width:300px" class="btn btn-success">Submit</button>
    </form>
    <br>
    <a href="/book"><button style="width:300px" class="btn btn-primary">&nbsp Back &nbsp</button></a>
  </div>
<br><br>
</body>
</html>