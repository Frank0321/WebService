# WebService
Web Service 範例
- java 17

## Server 端
- 啟動 port 8090
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

### request 和 response
- req 
```
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:gs="http://WebServiceServer.ws.yt.com.tw/book">
    <soapenv:Header/>
    <soapenv:Body>
        <gs:getBookRequest>
            <gs:isbn>9789861856216</gs:isbn>
        </gs:getBookRequest>
    </soapenv:Body>
</soapenv:Envelope>
``
- res
```
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
    <SOAP-ENV:Header/>
    <SOAP-ENV:Body>
        <ns2:getBookResponse xmlns:ns2="http://WebServiceServer.ws.yt.com.tw/book">
            <ns2:book>
                <ns2:isbn>9789861856216</ns2:isbn>
                <ns2:name>冰與火之歌：權力遊戲</ns2:name>
                <ns2:author>喬治馬汀</ns2:author>
                <ns2:publishing>2011</ns2:publishing>
                <ns2:edition>1</ns2:edition>
            </ns2:book>
        </ns2:getBookResponse>
    </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```

## resource
- [spring doc](https://spring.io/guides/gs/producing-web-service)
- [昕力資訊 sample code](https://www.tpisoftware.com/tpu/articleDetails/1968)


## client 端