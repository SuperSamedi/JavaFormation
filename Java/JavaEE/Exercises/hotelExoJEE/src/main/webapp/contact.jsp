<%--
  Created by IntelliJ IDEA.
  User: JAVA
  Date: 19-07-22
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="assets/include/toADD.jsp"%>
</head>
<body>

<%@include file="assets/include/navBar.jsp"%>

<div class="container">
  <div class=" text-center mt-5 ">


    <!--Google map-->
    <div id="map-container-google-1" class="z-depth-1-half map-container">
      <iframe src="https://maps.google.com/maps?q=brussels&t=&z=13&ie=UTF8&iwloc=&output=embed" width="400" height="280" frameborder="0"
              style="border:0" allowfullscreen></iframe>
    </div>

    <h1 >Contact Us</h1>


  </div>


  <div class="row ">
    <div class="col-lg-7 mx-auto">
      <div class="card mt-2 mx-auto p-4 bg-light">
        <div class="card-body bg-light">

          <div class = "container">
            <form id="contact-form" role="form">



              <div class="controls">

                <div class="row">
                  <div class="col-md-6">
                    <div class="form-group">
                      <label for="form_name">Firstname *</label>
                      <input id="form_name" type="text" name="name" class="form-control" placeholder="Please enter your firstname *" required="required" data-error="Firstname is required.">

                    </div>
                  </div>
                  <div class="col-md-6">
                    <div class="form-group">
                      <label for="form_lastname">Lastname *</label>
                      <input id="form_lastname" type="text" name="surname" class="form-control" placeholder="Please enter your lastname *" required="required" data-error="Lastname is required.">
                    </div>
                  </div>
                </div>
                <div class="row">
                  <div class="col-md-6">
                    <div class="form-group">
                      <label for="form_email">Email *</label>
                      <input id="form_email" type="email" name="email" class="form-control" placeholder="Please enter your email *" required="required" data-error="Valid email is required.">

                    </div>
                  </div>
                  <div class="col-md-6">
                    <div class="form-group">
                      <label for="form_need">Please specify your need *</label>
                      <select id="form_need" name="need" class="form-control" required="required" data-error="Please specify your need.">
                        <option value="" selected disabled>--Select Your Issue--</option>
                        <option >Request Invoice for order</option>
                        <option >Request order status</option>
                        <option >Haven't received cashback yet</option>
                        <option >Other</option>
                      </select>

                    </div>
                  </div>
                </div>
                <div class="row">
                  <div class="col-md-12">
                    <div class="form-group">
                      <label for="form_message">Message *</label>
                      <textarea id="form_message" name="message" class="form-control" placeholder="Write your message here." rows="4" required="required" data-error="Please, leave us a message."></textarea
                      >
                    </div>

                  </div>


                  <div class="col-md-12">

                    <input type="submit" class="btn btn-success btn-send  pt-2 btn-block
                            " value="Send Message" >

                  </div>

                </div>


              </div>
            </form>
          </div>
        </div>


      </div>
      <!-- /.8 -->

    </div>
    <!-- /.row-->

  </div>
</div>




<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>

</body>
</html>
