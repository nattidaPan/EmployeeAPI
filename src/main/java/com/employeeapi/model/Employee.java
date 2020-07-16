package com.employeeapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
		
		@Id
		private Long id;
		private String name;
		private String surname;
		private String JobTitle;
		
		public Employee() {
			super();
		}

		public Employee(Long id, String name, String surname, String jobTitle) {
			super();
			this.id = id;
			this.name = name;
			this.surname = surname;
			JobTitle = jobTitle;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getSurname() {
			return surname;
		}

		public void setSurname(String surname) {
			this.surname = surname;
		}

		public String getJobTitle() {
			return JobTitle;
		}

		public void setJobTitle(String jobTitle) {
			JobTitle = jobTitle;
		}
			

}
