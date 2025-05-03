# WebService
Web Service 範例
- java 17

## Server 端
### 使用 依賴
```
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-web-services</artifactId>
</dependency>
<dependency>
	<groupId>wsdl4j</groupId>
	<artifactId>wsdl4j</artifactId>
</dependency>
```
### 建立 java 物件
- 新增 src/main/resources/book.xsd
  - targetNamespace 為預計生成的位置，先修改為 "http://www.example.com/book"
  - xmlns:tns 這個也需要一並做修改
  
```
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema"
	targetNamespace="http://tw.com.yt.ws.WebServiceServer/book"
	xmlns:tns="http://tw.com.yt.ws.WebServiceServer/book" elementFormDefault="qualified">
	<xs:element name="getBookRequest">
		<xs:complexType>
			<xs:sequence>
				<xs:element name="isbn" type="xs:string" />
			</xs:sequence>
		</xs:complexType>
	</xs:element>
	<xs:element name="getBookResponse">
		<xs:complexType>
			<xs:sequence>
				<xs:element name="book" type="tns:book" />
			</xs:sequence>
		</xs:complexType>
	</xs:element>
	<xs:complexType name="book">
		<xs:sequence>
			<xs:element name="isbn" type="xs:string" />
			<xs:element name="name" type="xs:string" />
			<xs:element name="author" type="xs:string" />
			<xs:element name="publishing" type="xs:string" />
			<xs:element name="edition" type="xs:int" />
		</xs:sequence>
	</xs:complexType>
</xs:schema>
```
- 在專案目錄底下執行 : `mvn compile `

## resource
- [spring doc](https://spring.io/guides/gs/producing-web-service)



## client 端