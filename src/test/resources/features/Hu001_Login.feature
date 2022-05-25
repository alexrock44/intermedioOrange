#Roberto Sanabria
# 23-05-2022
  @Regresion
  Feature: ingreso a la pagina
    @Login
    Scenario Outline: login credenciales exitosas
      Given open browser
      And diligenciar user <user> y contrasena <pass>

      Examples:
      |user|pass|
      |Admin|admin123|

    @AddEmployee
    Scenario Outline: crear un empleado
      Given open browser
      And diligenciar user <user> y contrasena <pass>
      And llegar a la opcion agregar empleado
      When diligencie name <name> y apellido <lastName>

      Examples:
        |user|pass|name|lastName|
        |Admin|admin123|alexander|sanabria|