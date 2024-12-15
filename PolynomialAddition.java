import java.util.Scanner;

class PolynomialNode {
    int coefficient, exponent;
    PolynomialNode next;

    PolynomialNode(int coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
        this.next = null;
    }
}

class Polynomial {
    PolynomialNode head;

    // Insert a term in the polynomial in sorted order by exponent
    public void insertTerm(int coefficient, int exponent) {
        PolynomialNode newNode = new PolynomialNode(coefficient, exponent);

        if (head == null || head.exponent < exponent) {
            newNode.next = head;
            head = newNode;
        } else {
            PolynomialNode current = head;
            while (current.next != null && current.next.exponent > exponent) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    // Display the polynomial
    public void display() {
        if (head == null) {
            System.out.println("0");
            return;
        }
        PolynomialNode current = head;
        while (current != null) {
            System.out.print(current.coefficient + "x^" + current.exponent);
            if (current.next != null) System.out.print(" + ");
            current = current.next;
        }
        System.out.println();
    }

    // Add two polynomials
    public static Polynomial add(Polynomial p1, Polynomial p2) {
        Polynomial result = new Polynomial();
        PolynomialNode t1 = p1.head, t2 = p2.head;

        while (t1 != null && t2 != null) {
            if (t1.exponent == t2.exponent) {
                int sumCoeff = t1.coefficient + t2.coefficient;
                if (sumCoeff != 0) {
                    result.insertTerm(sumCoeff, t1.exponent);
                }
                t1 = t1.next;
                t2 = t2.next;
            } else if (t1.exponent > t2.exponent) {
                result.insertTerm(t1.coefficient, t1.exponent);
                t1 = t1.next;
            } else {
                result.insertTerm(t2.coefficient, t2.exponent);
                t2 = t2.next;
            }
        }
        // Add remaining terms
        while (t1 != null) {
            result.insertTerm(t1.coefficient, t1.exponent);
            t1 = t1.next;
        }
        while (t2 != null) {
            result.insertTerm(t2.coefficient, t2.exponent);
            t2 = t2.next;
        }

        return result;
    }
}

public class PolynomialAddition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create two polynomials
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();

        // Input first polynomial
        System.out.println("Enter the number of terms for the first polynomial:");
        int n1 = scanner.nextInt();
        System.out.println("Enter terms (coefficient and exponent):");
        for (int i = 0; i < n1; i++) {
            int coeff = scanner.nextInt();
            int exp = scanner.nextInt();
            p1.insertTerm(coeff, exp);
        }

        // Input second polynomial
        System.out.println("Enter the number of terms for the second polynomial:");
        int n2 = scanner.nextInt();
        System.out.println("Enter terms (coefficient and exponent):");
        for (int i = 0; i < n2; i++) {
            int coeff = scanner.nextInt();
            int exp = scanner.nextInt();
            p2.insertTerm(coeff, exp);
        }

        // Display input polynomials
        System.out.println("First Polynomial:");
        p1.display();
        System.out.println("Second Polynomial:");
        p2.display();

        // Add the polynomials
        Polynomial result = Polynomial.add(p1, p2);

        // Display result
        System.out.println("Resultant Polynomial after addition:");
        result.display();
    }
}


/*
a) To implement Polynomial Addition
Polynomial addition using linked lists in Java involves creating a 
data structure to represent terms of the polynomial, implementing methods to 
traverse and add corresponding terms, and displaying the result
Step-by-Step Implementation
1.	Create a Node Class Each node represents a term in the polynomial, containing:
o	The coefficient.
o	The exponent.
o	A reference to the next node.
2.	Create a LinkedList Class The class manages the polynomial and provides methods to:
o	Insert terms into the list.
o	Add two polynomials.
o	Display the polynomial.
3.	Take User Input Allow the user to enter the coefficients and exponents for two polynomials.
4.	Add Polynomials Traverse both linked lists, comparing exponents and adding
coefficients of terms with matching exponents.
5.	Output the Result Display the resulting polynomial after addition.


Step-by-Step Execution
1.	User Input
Example Input:
o	First Polynomial: 2x^3 + 3x^2
o	Second Polynomial: 4x^3 + 5x^1
User enters:
2.	Number of terms: 2  
3.	Coefficient and Exponent: 2 3  
4.	Coefficient and Exponent: 3 2  
5.	Number of terms: 2  
6.	Coefficient and Exponent: 4 3  
7.	Coefficient and Exponent: 5 1  
8.	Insert Terms into Linked Lists
After insertion:
o	First Polynomial: 2x^3 -> 3x^2
o	Second Polynomial: 4x^3 -> 5x^1
9.	Addition Logic
o	Compare exponents: 
	2x^3 + 4x^3 = 6x^3
	3x^2 = 3x^2
	5x^1 = 5x^1
o	Resultant polynomial: 6x^3 + 3x^2 + 5x^1.
10.	Display Output
11.	First Polynomial: 2x^3 + 3x^2  
12.	Second Polynomial: 4x^3 + 5x^1  
13.	Resultant Polynomial: 6x^3 + 3x^2 + 5x^1

How the Code Works
1.	Insertion: Terms are inserted in descending order of exponents to simplify addition.
2.	Addition: 
o	Traverse both lists simultaneously.
o	Add coefficients of terms with matching exponents.
o	Append terms with non-matching exponents to the result.
3.	Output: Displays the formatted polynomial by traversing the result linked list.

*/