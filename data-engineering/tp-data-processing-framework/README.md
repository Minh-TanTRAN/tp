# Practices - Data engineering

## TP - Data processing with Apache Spark
To process a large amount of data partitioned on a data lake, you can use data processing frameworks such as Apache Spark :
1. Read : https://spark.apache.org/docs/latest/sql-programming-guide.html

Some questions :
* What is Spark RDD API ?  
RDD was the primary user-facing API in Spark since its inception. At the core, an RDD is an immutable distributed collection of elements of your data, partitioned across nodes in your cluster that can be operated in parallel with a low-level API that offers transformations and actions.
Spark RDD API is the core data processing API in Apache Spark, which provides a simple and flexible interface for processing data in distributed systems. RDDs are a fault-tolerant, immutable distributed collection of objects that can be processed in parallel across a cluster of machines. RDDs can be created from various data sources and allow developers to write complex data processing algorithms using a set of simple and intuitive operations. The RDD API is the basic building block of all other Spark APIs.  
source : https://www.databricks.com/glossary/what-is-rdd#:~:text=RDD%20was%20the%20primary%20user,that%20offers%20transformations%20and%20actions.
***
* What is Spark Dataset API ?  
The Apache Spark Dataset API provides a type-safe, object-oriented programming interface.
The Spark Dataset API is a distributed collection of data organized into named columns, which provides a higher-level, type-safe, and efficient interface for working with structured and semi-structured data in Apache Spark. It combines the benefits of RDDs and DataFrames API and is optimized for performance and parallel processing across a cluster of machines. The Dataset API supports a wide range of data sources, including structured and semi-structured data formats and non-relational data sources.  
source : https://www.databricks.com/spark/getting-started-with-apache-spark/datasets#:~:text=The%20Apache%20Spark%20Dataset%20API,an%20untyped%20Dataset%20%5BRow%5D%20.  
***

* With which languages can you use Spark ? 

Apache Spark can be used with multiple programming languages, including Scala, Java, Python, R, and SQL. This allows developers and data scientists to choose the language that best suits their needs and expertise.  
source : https://www.knowledgehut.com/blog/programming/scala-vs-python-vs-r-vs-java
***
* Which data sources or data sinks can Spark work with ?

Apache Spark can work with a wide range of data sources and sinks, including structured and unstructured data sources, streaming data sources, NoSQL databases, graph data, and machine learning data. This versatility makes Spark a powerful tool for data processing and analytics in various use cases.  
source : https://kodey.co.uk/2020/05/23/spark-streaming-data-sources-and-sinks/
***


### Analyse data with Apache Spark and Scala 
One engineering team of your company created for you a TV News data stored as JSON inside the folder `data-news-json/`.

Your goal is to analyze it with your savoir-faire, enrich it with metadata, and store it as [a column-oriented format](https://parquet.apache.org/).

1. Look at `src/main/scala/com/github/polomarcus/main/Main.scala` and update the code 

**Important note:** As you work for a top-notch software company following world-class practices, and you care about your project quality, you'll write a test for every function you write.

You can see tests inside `src/test/scala/` and run them with `sbt test`

### How can you deploy your app to a cluster of machines ?
* https://spark.apache.org/docs/latest/cluster-overview.html

### Business Intelligence (BI)
How could use we Spark to display data on a BI tool such as [Metabase](https://www.metabase.com/) ?

Tips: https://github.com/polomarcus/television-news-analyser#spin-up-1-postgres-metabase-nginxand-load-data-to-pg

### Continuous build and test
**Pro Tips** : https://www.scala-sbt.org/1.x/docs/Running.html#Continuous+build+and+test

Make a command run when one or more source files change by prefixing the command with ~. For example, in sbt shell try:
```bash
sbt
> ~ testQuick
```