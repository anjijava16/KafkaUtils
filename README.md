
# URL : Kafka Documenation : 
https://kafka.apache.org/documentation/

# URL: Kafka Confluent (Adv Kafka)
https://docs.confluent.io/current/index.html 
http://cloudurable.com/blog/kafka-ecosystem/index.html


https://www.learningjournal.guru/courses/kafka/kafka-foundation-training/


source 'create-timeseries.cql';
 
 Kafka Componets
 i)Producers (publishers records to the topics in kafka)
 ii)Consumers (Pulls records stored in kafka topics)
 iii)Streams (Stream processer : Client Libray for processing data stored in kafka)
 iv)Connectors (A framework to build connectors for in/out movement of data bewteen kafka and other systems)
  DB to Kafka(Import) <<==>> Kafka to DB(Export)
 ==============================
 
 Stream Processer : stream and processing 
 Kafka Connector : Spark 
 
 Kafka :Distribute Streaming Platofmr
    ==> It is publish and subscribe to stremas of records ,In the respect it similar to a message queue or enterprise message system
	==> It is store streams of records in a fault-tolerant way
	==> It is process streams of records as they occur
	
	
	Message system
	
	Producer 1         --->     Consumer 1
	
	             Message Broker   
   Producer 2                 ---> Consumer 2				 
 
 
 Kafka Cluster : Broker (OR) Kafka Servers
 
 
 Producer : An application that sends data to kakfa
 Consumer  : An application that receives data from kafka
 Broker : kafka Server
 Cluster : Group of clusters
 Topic :  A name for a kafka Stream
 Partitions : Part of a topic
  OffSet : Unique id for a message with in the Partition
 ConsumerGroups: A group of consumers acting as a single logical unit .
 
 
 
 Producer: an application that sends messages to kafka
     small to medium sized piece of data  (Simple array of bytes)
	 A text files sending means each line of words is message 1,message 2,message 3,.....message n
	 
	 Example all records of table each row as message or 
	 
Consumer: An APplication that receives data from kafka

Producer --- SendMessage ---> Kafka Server ---Messages---> Consumer

Broker ---> Kafka Servers  Kafka Server : Agent /Broker

Cluster: ===> A group of computer sharing workload for common purpose.


Topic: A Topic is a unique name for KafaServer



Disiributed System that run of clusters of computers 
Break topic storeds mutliple partitions 
How many Partitiions?
Kafka Topic ====>> 100 partitions ?
Kafka doesn't take decision when we created we need to take decisiion?
Every partitions sit of single mechinsacm


=============
OffSet : A sequence id given to messages as they arrive in a partitions
A Partitions
 M1 M2 M3 M4 M5 ..... Messages Writes
 0  1  2 3  3     
 
 This offsets number can't changes it is immutable ..
 
 First Message : 0
 Second Message : 1
 
 
 Note: No Gloable Offset ,OffSets are local only...
 
 Global Unique Identifier of a message ?
 
 TopicName ---> PartiitonNuber ---> OffSet
 
 
 
 Consumer Group :
   A group of Consumers acting as a single logical Unit
   
   Reatiler Organization =====================> DataCenter 
   
   Consumer Group
     i)  Consumer
	 ii) COnsumer
	 iii) Consumer
 
 
 600 Partiitons ==>> 100 Consumer each one take 6 
 
 Partitions and Consumer tool for scalabiltiy of the Kafka Applications....
 
 Kafka Doesn't allow more than 2 consumer to read for the same partiitons symnosully 
 
 
 Zookerper : is used for co-ordination service for distibuted systems.
 Zookerper is centraiized service for mainiting configuration information,naming,providing distitued synchronzation,and provding group servies
 
 Zookerper : 2181 
 
 
 
 Fault Tolerance:Making the data Enabling a system to continue operating properly in the event of the failure  of some of its componets
 
 Kafak Spread data in different systems
 
 Fault Tolerance : It means making data avaible in case of data failed 
 Two more copies of  3 copies of 3 system ,if event 2 system failed also no issues
 
 What is replication factors
    Number of total copies 
	
	  i) => Kafka Implements Fault toleanrce(replication factor for the TOPIC)
	   ii)  Every partiitons one is elected as Leader ,Leader is takes care all client interactions 
	   Leader takes cares request and responses .
	   
	   Replication factors : set is 3
	   3 Nodes 
 
 
 
 
 
 
 $KAFKA_HOME/bin/zookeeper-server-start.sh $KAFKA_HOME/config/zookeeper.properties

 
 $KAFKA_HOME/bin/kafka-server-start.sh $KAFKA_HOME/config/server.properties &
 $KAFKA_HOME/bin/kafka-server-start.sh $KAFKA_HOME/config/server-1.properties &
 $KAFKA_HOME/bin/kafka-server-start.sh $KAFKA_HOME/config/server-2.properties &
 
 
Topic Creation CLI:  
 $KAFKA_HOME/bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic MyTestXYZ
 
 $KAFKA_HOME/bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 3 --partitions 2 --topic MyTestXYZ

========================================================
Deleting TOPIC 
Deleting the Topic : $KAFKA_HOME/bin/kafka-topics.sh --delete --zookeeper localhost:2181 --topic MyTestXYZ
hadoop@hadoop:~$ $KAFKA_HOME/bin/kafka-topics.sh --delete --zookeeper localhost:2181 --topic MyTestXYZ
Picked up JAVA_TOOL_OPTIONS: -javaagent:/usr/share/java/jayatanaag.jar 
Topic MyTestXYZ is marked for deletion.
Note: This will have no impact if delete.topic.enable is not set to true.
hadoop@hadoop:~$ $KAFKA_HOME/bin/kafka-topics.sh --list --zookeeper localhost:2181



Deletion of a topic has been supported since 0.8.2.x version. You have to enable topic deletion (setting delete.topic.enable to true) on all brokers first.
Follow this step by step process for manual deletion of topics
Stop Kafka server

========================================================
List Of Topics: $KAFKA_HOME/bin/kafka-topics.sh --list --zookeeper localhost:2181


Description of topics :

$KAFKA_HOME/bin/kafka-topics.sh --zookeeper localhost:2181 --describe -topic MyTestXYZ

Output:

hadoop@hadoop:/tmp$ $KAFKA_HOME/bin/kafka-topics.sh --zookeeper localhost:2181 --describe -topic MyTestXYZ
Picked up JAVA_TOOL_OPTIONS: -javaagent:/usr/share/java/jayatanaag.jar 
Topic:MyTestXYZ	PartitionCount:2	ReplicationFactor:3	Configs:
	Topic: MyTestXYZ	Partition: 0	Leader: 2	Replicas: 2,0,1	Isr: 2,0,1
	Topic: MyTestXYZ	Partition: 1	Leader: 0	Replicas: 0,1,2	Isr: 0,1,2
hadoop@hadoop:/tmp$ 

Replication factor :3
Here We have 2 partiions 2 one for each row 
First Partiions 0 & another 1
Leader For First partiitons Broker 1 is leader 
                           Broker 2 is leade for second partiions 
Replicas : 1,2,0
   Here Leader is 1 and 2,0 is Followers

IN Second partions Leader is 0 and Followers 1,2


ISR : List of In Sync Replication 
List of replication that are sysnc with the Leader 


Apache Broker Configuaation Details

i)broker.id
ii)port
iii)log.dirs
iv)zookeeper.connect
v)delete.topic.enable
vi)auto.create.topics.enable
vii)default.repilication.factor
viii)num.partitions
ix)log.retention.ms
x)log.retention.bytes


zookeeper.connect : it is connect to all broker configuration using zookper address.

delete.topic.enable : By default is not allowed
we want to set true if you want delete topic any time.


auto.create.topics.enable :==> 
default.replication.factor:1
num.parititons: 1


$KAFKA_HOME/bin/kafka-console-consumer.sh --zookeeper localhost:2181 --topic MyTestXYZ --from-beginning



Kafak Supports Different Serilalizers (key.serializer and value.serializer)
  i)IntSerilalizer
  ii)StringSerilizer
  iii)DoubleSerilizer
  
  KafkaProducer:
  
  KafkaProducer(java.util.Map<java.lang.String,java.lang.Object> configs)
     A producer is instantiated by providing a set of key-value pairs as configuration.
KafkaProducer(java.util.Map<java.lang.String,java.lang.Object> configs, Serializer<K> keySerializer, Serializer<V> valueSerializer)
    A producer is instantiated by providing a set of key-value pairs as configuration, a key and a value Serializer.
KafkaProducer(java.util.Properties properties)
   A producer is instantiated by providing a set of key-value pairs as configuration.
KafkaProducer(java.util.Properties properties, Serializer<K> keySerializer, Serializer<V> valueSerializer)
  A producer is instantiated by providing a set of key-value pairs as configuration, a key and a value Serializer.
  
  
  void	close()
Close this producer.
void	close(long timeout, java.util.concurrent.TimeUnit timeUnit)
This method waits up to timeout for the producer to complete the sending of all incomplete requests.
void	flush()
Invoking this method makes all buffered records immediately available to send (even if linger.ms is greater than 0) and blocks on the completion of the requests associated with these records.
java.util.Map<MetricName,? extends Metric>	metrics()
Get the full set of internal metrics maintained by the producer.
java.util.List<PartitionInfo>	partitionsFor(java.lang.String topic)
Get the partition metadata for the give topic.
java.util.concurrent.Future<RecordMetadata>	send(ProducerRecord<K,V> record)
Asynchronously send a record to a topic.
java.util.concurrent.Future<RecordMetadata>	send(ProducerRecord<K,V> record, Callback callback)
Asynchronously send a record to a topic and invoke the provided callback when the send has been acknowledged.




ProducerRecords:
ProduerRecord(String topic,Integer partition,Logn timeStatmp,K Key,V value)
ProducerRecord(String topic,K key,V value)
ProducerRecord(String topic,V value)

=======================================================================


Client(USER) ====> Producer(Data) =====>> Kafka Broker 

Step 1:
  Properties 
    i)bootstrap.servers
	ii)key.serializer
	iii)value.serializer
	Other...(Custom config)
	
	
	
Step 2:
  ProduceerRecord
    i)TopciName
	ii)Partition No.
	iii)TimeStamp
	iv)Key
	v)Value
	

Step 3: Producer :
         Serializer  (Key and Value) object convert into Byte Array (i,e:Interally:byte[] abc) ===> 
		 Partiioner (Assign Partition #)
		   |
		   |
		   Partition Buffer( Producer Record1 ,Producer Record2 .....)  
		   |
		   |
		    KafakBroker -->
			|
		    |
		   SUCCESS ---> YES ---> RecordMetaData(OffSet,TimeStamp)
		 
		    (Interanlly :: Round Robin Alogrithm   ---> ))
			
		
If Leader is  down we can configure retry in Producer end 


3 Apporache we can send message Producers to brokers
i) Fire and Forget
ii)Sysnchronus Send : direct write the RecordMetadata information.
iii)Asynchronus Send implements Callback Interface.


Fire(send) and Forget  :===>>
=============================================================
Kafak is Distributed system.(response is fast but some message will lose)

Synchronus Send :===> Wait untill get the response .. SUccess we will Get RecordMetaData Info.(it message critiacal it is slow ,it is slow because waiting for acknolegement for every messages)

========================================
max.in.flight.requests.per.connection(how many message can send to the server with out receving the response to server)
The default value is 5


======================================================================================

Kafka Partitions : Resposnble for deciding for the partition number for each numbers


  Default Partitioner
  i) If a partiitoner is specified in the record , Use it
  
  ii) If no partition is specified but a key is present choose a partition based on Hash of the Key
  
  iii)If no Partition or key is pressent choose a partition in a round-robil Fashion
  
  


==================================
Kafka Producer Configuration
  i)bootstrap.servers
  ii)key.serializer
  iii)value.serialier
  iv)partitioner.class (Custom partitioner)
  
  
acks  : ==> 
retries
max.in.flight.requests.per.connection

When producer send to kafka broker response is meta data object or execption
acks: Configure Response back from brocker 
acks=0; (No acknowledgement)
   => Possible loss of messages
   => High Throughput
   => No Retries
   
acks=1 ;
    RecordMetaData: Response send by leader,if leader is down the producer is down  
	RecordMetaData
	 OffSet
	 Timestamp
What is leader is crash :--> the messag will be lose ..	 
	 
acks=all;
  The leader will acknowledgemnet it is hight reliablity .
  
========================
Retries :=> The default value is 0
100 milliseconds default

============================
max.in.flight.request.
Asyscnrhous Sends :==>> Require high memory require
Producer
ProducerBuffer ProducerBuffer            KafkaBroker
 Use Synchronous Send
 max.in.flights.requests.per.connection=1
 
 ========================================
 
 
  
Producer 1                          Consumer 1

Producer 2      Kafka Broker                         Consumer 2

Producer 3                          Consumer 3



Consumer Group :
How do we read Message parallel?
 ==========================================
 How to parallel read in a single application?
 Using Group : consumer Group 
 
 One of the Kafka 
  Co-ordinator: >>
  i) Manage a list of Group memebers
  ii)Initites a rebalance activity(block the read for all memebers)
  iii)Communicate about nre assignemnts to consumers
  
  Leader ---> Co-ordinator 
  i)Executes the rebalance activity
  ii)Send new partitions assignement to co-ordintator
  
  
  
  Consumer Groups : used to read and process data in paralle
 Partitions : Are never shared among memembers of same group at the same time
 Group Co-ordinator => Maintains a list of active consumers
 Rebalance=>Intiated when the list of consumers is modified
 Group Leader : Executes a rebalcne activity
 
 
 ==================================================
 
 Kafak Consumers:
 
 Properties Object
 i)bootStrarp serveers
 
 ii)groupId
 iii)KeyDesializeer and Value Deserializer
 
 Do I need to Create Group ?
 
 
 // Kafka Consumer Object
 KafkaConsumer <String,String> consumer=new KafkaConsumer<>(props)
 consmer.subscribe(Arrays.asList(topicName))
 
 // while(true){
 ConsumerRecords<String,String> records=Consumer.poll(100)
 
 Here poll:
   Connect to group co-ordinator
   Join the Group
   Receives partition assignemnt
   Sends heartbeat
   Fetches you messages
   And many more 
   
   Note: while(true)
   // Make Sure each iteration completes in less than 3 Seconds
   
   // Set heartbeat.interval.ms and session.timeout.ms to higher if can't poll every 3 seconds.
   
   for(ConsumerRecord<String,Supplier>record:Recors){
   
   Sysout(record.value.getID()+""+
   }
 
 }
 
 OffSet
 CurrentOffSet -->SentRecords
 CommitOffSet---> Avoid resending same records?
 
 CommitOffSet
   ->AutoCommit
   -->ManualCommit
   
   AutoCommit
     ->enable.auto.commit(true:default)
	 ->aut.commit.internaval.ms (default: 5 Seconds)
	 
	 Manual Commit
	   set enable.auto.commit=false
	     commit Sync: Staright forward
		 commit Async: willn't retries
		 

consumer.commitAsync();
consumer.commitSync();
consumer.close();

Kafka : handle 

		 
 
  
  
 






























































		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
	
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
















  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  










































   























 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 






















	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
