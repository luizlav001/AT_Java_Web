<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<form action="confirmacao.html" method="post">
			<div class="form-group">
				<label>Nome:</label> 
				<input type="text" class="form-control" placeholder="Entre com seu nome" name="name">
			</div>

			<div class="form-group">
				<label>E-mail:</label> 
				<input type="email"class="form-control" placeholder="Entre com seu email"name="email">
			</div>

			<div class="form-group">
				<label>Escolaridade:</label> 
				<div class="form-check-inline">
				  <label class="form-check-label">
				   <input type="radio" name="escolaridade" class="form-check-input" value="G">Graduação
				  </label>
				</div>
				
				<div class="form-check-inline">
				  <label class="form-check-label">
				   <input type="radio" name="escolaridade" class="form-check-input" value="E">Especialização
				  </label>
				</div>
				
				<div class="form-check-inline">
				  <label class="form-check-label">
				   <input type="radio" name="escolaridade" class="form-check-input" value="D">Doutorado
				  </label>
				</div>
				
				<div class="form-check-inline">
				  <label class="form-check-label">
				   <input type="radio" name="escolaridade" class="form-check-input" value="M">Mestrado
				  </label>
				</div>
			</div>
				
			<div class="form-group">
					<label>Disciplinas:</label> 
				<div class="form-check-inline">
				  <label class="form-check-label">
				   <input type="checkbox" name="disciplinas" class="form-check-input" value="Fun">Fundamentos Java
				  </label>
				</div>
	
				<div class="form-check-inline">
				  <label class="form-check-label">
				   <input type="checkbox" name="disciplinas" class="form-check-input" value="POO">Orientação a objetos 
				  </label>
				</div>
				
				<div class="form-check-inline">
				  <label class="form-check-label">
				   <input type="checkbox" name="disciplinas" class="form-check-input" value="Web">Java Web
				  </label>
				</div>
				
				<div class="form-check-inline">
				  <label class="form-check-label">
				   <input type="checkbox" name="disciplinas" class="form-check-input" value="Nuvem">Java Nuvem
				  </label>
				</div>
			</div>
			
			<div class="form-group">
				<label>Regiões:</label>
					<select class="form-control" name="regiao">
						<option value="S">Sul</option>
						<option value="Su">Sudeste</option>
						<option value="N">Norte</option>
						<option value="No">Nordeste</option>
						<option value="C">Centro-Oeste</option>
					</select>
			</div>
					<button class="btn btn-danger" type="submit">Cadastrar</button>
		</form>
	</div>
</body>
</html>