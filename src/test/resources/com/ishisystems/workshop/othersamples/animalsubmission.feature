Feature: Animal Submission

As a Zoologist
I want to add a new animal to the site
So that I can share my animal knowledge with the community

Scenario: successful submission
Given I"m on the animal creation page

When I add a new animal

Then I should see the page for my newly created animal
And the notice "Thank you for your animal submission!"

@When("^I add a new animal$")
public void I_add_a_new_animal() throws Throwable {
fillsIn("Name",with("Alligator"));
selects("Chordata"),from("Phylum"));
fillsIn("Animal Class",with("Sauropsida"));
fillsIn("Order",with("Crocodilia"));
fillsIn("Family",with("Alligatoridae"));
fillsIn("Genus",with("Alligator"));
checks("Lay Eggs");
clicks_button("Create");
}