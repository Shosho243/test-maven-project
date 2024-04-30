package org.example;

public class Park {
    private String city;
    private String street;

    public class Attraction {
        private String name;
        private String openingTime;
        private String closingTime;
        private double cost;

        public Attraction(String name, String openingTime, String closingTime, double cost) {
            this.name = name;
            this.openingTime = openingTime;
            this.closingTime = closingTime;
            this.cost = cost;
        }

        public void parkInfo() {
            System.out.println("Парк находится в городе " + city + ", на улице " + street);
            System.out.println("Аттракцион " + name + "; Время открытия: "
                    + openingTime + "; Время закрытия: " + closingTime + ";Стоимость билета  :" + cost);
        }
    }

    public Park(String city, String street) {
        this.city = city;
        this.street = street;
    }
}

