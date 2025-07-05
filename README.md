
##JAVA-PROGRAMMING-TASK

COMPANY: CODTECH IT SOLUTIONS PVT. LTD

NAME: PREM ANANDRAO SAWANT

INTERN ID: CT04DH1720

DOMAIN: JAVA PROGRAMMING

DURATION: 4 WEEKS (5th July 2025 to 5th August 2025)

MENTOR: NEELA SANTHOSH

📌 Task 2: Crypto Price Fetcher – Real-Time API Integration in Java

📝 Description of the Task:

This task focused on building a real-time cryptocurrency price fetcher using Java networking and API handling concepts. The objective was to create a console-based application that interacts with the CoinGecko public API to fetch the latest prices of selected cryptocurrencies—namely Bitcoin, Ethereum, and Dogecoin—in USD. The application performs a GET request to an API endpoint and displays the result in a formatted table without using any third-party libraries for JSON parsing. This task helped bridge Java with real-world web data interaction.

💡 What I Learned:

From this task, I learned the practical use of Java's networking and HTTP handling libraries, including how to:

Send HTTP GET requests using HttpURLConnection

Read and process API responses using BufferedReader and InputStreamReader

Work with manual JSON string parsing (since no external libraries like Gson or Jackson were used)

Format console output in a tabular structure

Handle errors gracefully such as HTTP failures or parsing exceptions

This task was my first interaction with external REST APIs using Java and taught me how important it is to validate, parse, and display data coming from dynamic sources like the web.

🛠 Technologies Used:

Java (Core Java SDK)

Java.net package for HTTP connection

CoinGecko public API (https://api.coingecko.com/)

JSON parsing (manually without external libraries)

Standard input/output stream readers

String manipulation and collection handling (Map, LinkedHashMap)

🔍 Features Implemented:

Connects to CoinGecko API to fetch prices of cryptocurrencies.

Automatically builds a query string using user-defined coins.

Makes an HTTP GET request with correct headers.

Reads and collects API response.

Parses JSON manually to extract price values.

Displays the final result in a clean and readable table format.

Handles scenarios where prices may not be fetched successfully.

🧠 Code Explanation:

The core logic begins in the main method by preparing a comma-separated string of cryptocurrencies like bitcoin, ethereum, and dogecoin, encoded properly for the API call.

An HTTP GET request is then made to the CoinGecko API endpoint. The response is received in JSON format and read line-by-line into a StringBuilder object.

Instead of using a JSON parser library, the response string is manually searched using indexOf to locate the currency keys and extract the USD price. These prices are then parsed into Double values and stored in a LinkedHashMap to preserve the order.

A helper method displayPrices is used to print the output neatly in a table format with coin names and their respective prices.

⚠️ Challenges Faced:

One of the key challenges in this task was parsing the JSON manually. Without using a proper parser library like Gson or Jackson, I had to rely on substring operations, index detection, and error handling to extract prices. This made me more cautious about edge cases such as missing coins or invalid JSON structures.

Another challenge was ensuring the HTTP request was successful and that all headers were properly handled. Checking the response code before reading the stream ensured that no errors occurred while parsing invalid or failed requests.

🚀 How to Run the Code:

Ensure you are connected to the internet since this code fetches real-time data from the web.

Open any Java IDE or terminal.

Compile the file named CryptoPriceFetcher.java.

Run the compiled program.

The prices of Bitcoin, Ethereum, and Dogecoin will be printed in a table format.

📦 Sample Output:

<img width="1920" height="1080" alt="Image" src="https://github.com/user-attachments/assets/c5f08f8e-f324-4937-a0b1-4b390d3b9990" />


Note: Prices are dynamic and change each time based on the real-time API response.

🌱 Future Improvements:

Add more cryptocurrencies as user input instead of hardcoded coins.

Introduce currency conversion options beyond USD.

Implement full JSON parsing using Gson or Jackson for better scalability.

Create a simple GUI using JavaFX or Swing for better interaction.

✅ Conclusion:

This project greatly enhanced my understanding of how Java interacts with external APIs and how to handle JSON without relying on third-party tools. It also taught me how to build clean and structured output for better readability. Real-time API tasks like this are directly applicable to many real-world use cases in financial tech, data dashboards, and backend services.

I now feel more confident about fetching and processing live data in Java, making this one of the most practical and modern tasks of my internship so far.
