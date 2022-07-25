package net.javaguides.springmvc.helloworld.model;

import javax.persistence.*;

@Entity
@Table(name = "TBL_EMPLOYEES")
public class HelloWorld {
    
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        
        @Column(name = "first_name")
        private String firstName;
        
        @Column(name = "last_name")
        private String lastName;
        
        @Column(name = "email", nullable = false, length = 200)
        private String email;
        
          
	private String message;
	private String dateTime;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
        public Long getId() {
            return this.id;
        }
        public void setId(Long _id) {
            this.id = _id;
        }
        public String getFirstName() {
            return this.firstName;
        }
        public void setFirstName(String _firstName) {
            this.firstName = _firstName;
        }
        public String getLastName() {
            return this.lastName;
        }
        public void setLastName(String _lastName) {
            this.lastName = _lastName;
        }
        public String getEmail() {
            return this.email;
        }
        public void setEmail(String _email) {
            this.firstName = _email;
        }
        @Override
    public String toString() {
	return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
    }
}
