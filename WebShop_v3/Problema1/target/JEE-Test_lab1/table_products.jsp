<div style="overflow-x: auto;">
  <table>
    <tr>
      <th>Product Name</th>
      <th>Price</th>
      <th>Descrition</th>
      <th>Quantity</th>
      <th></th>
    </tr>
    <tr>
      <td>Ideapad</td>
      <td>3000 lei</td>
      <td>foarte bun</td>
      <td>
      	<form action="./add_to_chart" style="padding:0px; margin:0px;" class="add_chart_form" method="POST">
          <input type="hidden" name="id_produs" value="{% print(produs[0]) %}">
          <input type="hidden" name="id_comanda" value="{% print(produs[0]) %}">
          <div class="add_form_content">
            <div class="">
              <input class="quantity_input" type="text" name="cantitate_val" value="0">
            </div>
            <div class="">
              <input class="add_chart_button" type="submit" name="adauga_produs", value="Add to Chart" class="btn brand z-depth-0" >
            </div>
          </div>
        </form>
      </td>


    </tr>

  </table>
</div>