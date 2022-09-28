package employee.application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Address;
import model.entities.Department;
import model.entities.Employee;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US); 
		 Scanner sc = new Scanner(System.in); 
		 
		 System.out.print("Nome do departamento: ");
		 String nameDepartment = sc.nextLine();
		 System.out.print("Dia do pagamento: ");
		 int payDay = sc.nextInt();
		 System.out.print("Email: ");
		 sc.nextLine();
		 String email = sc.nextLine();
		 System.out.print("Telefone: ");
		 String phone = (String) sc.nextLine();
		 
		 Address adress = new Address(email, phone);
		 Department dept = new Department(nameDepartment, payDay, adress);
		 
		 System.out.print("Quantos funcionários tem o departamento? ");
		 int n = sc.nextInt();
		 
		 for (int i = 1; i <= n; i++) {
			System.out.println("Dados do funcionário " + i  + ":");
			System.out.print("Nome: ");
			String name = sc.next();
			sc.nextLine();
			System.out.print("Salário: ");
			Double salary = sc.nextDouble();
			
			Employee employee = new Employee(name, salary);
			dept.addEmployee(employee);
		 }
		 
		 System.out.println();
		 
		 showReport(dept);
		 
		 
	sc.close();	  
	}
	
	private static void showReport(Department dept) {
		System.out.println("\"FOLHA DE PAGAMENTO:");
		System.out.println("Departamento " + dept.getName() + " = R$ " + String.format("%.2f", dept.payroll()));
		System.out.println("Pagamento realizado no dia " + dept.getPayDay());
		System.out.println("Funcionários:");
		for (Employee emp : dept.getEmployees()) {
			System.out.println(emp.getName());
		}
		System.out.println("Para dúvidas favor entrar em contato: " + dept.getAddress().getEmail());
	}

}
