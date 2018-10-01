package fr.wildcodeschool.blablawild;

import java.util.Date;

public class TripModel {

        private String firstName;
        private String lastName;
        private Date dateHeure;
        private int price;

        public TripModel(String firstName, String lastName, Date dateHeure, int price) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.dateHeure = dateHeure;
            this.price = price;

        }

            // Getters

            public String getFirstName() {
                return this.firstName;
            }

            public String getLastName() {
                return this.lastName;
            }

            public Date getDateHeure() {
                return this.dateHeure;
            }

            public int getPrice() {
                return this.price;
            }

            // Setters

            public void setFirstName(String firstName){
                this.firstName = firstName;
            }

            public void setLastName(String lastName) {
                this.lastName = lastName;
            }
            public void setDateHeure(Date dateHeure) {
                this.dateHeure = dateHeure;
            }
            public void setPrice(int price) {
                this.price = price;
            }
    }

