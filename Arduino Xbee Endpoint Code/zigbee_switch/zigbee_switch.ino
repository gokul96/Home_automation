#define DATSTRT 17
#include <SoftwareSerial.h>
#include <XBee.h>

SoftwareSerial Sserial(2, 3);
XBee xbee = XBee();
XBeeResponse response = XBeeResponse();

ZBRxResponse rx = ZBRxResponse();
//ModemStatusResponse msr = ModemStatusResponse();

uint8_t packet[21]={0x7E,0x00,0x11,0x10,0x00,0x00,0x13,0xA2,0x00,0x41,0x54,0xED,0xDC,0xFF,0xFE,0x00,0x00,0x02,0x01,0x87,0x54};

void chksum()
{
  uint8_t checksum = 0x00;
  for(int i=3;i<20;i++)
    checksum+=packet[i];
  checksum= 0xFF-checksum;
  packet[20]=checksum;
}

void setup() 
{
 pinMode(13,  OUTPUT);
 pinMode(4, OUTPUT); 
 pinMode(5, OUTPUT); 
 pinMode(6, OUTPUT); 
 pinMode(7, OUTPUT); 
 pinMode(8, OUTPUT); 
 pinMode(9, OUTPUT); 
 pinMode(10, OUTPUT); 
 pinMode(11, OUTPUT);
 pinMode(12, OUTPUT); 

  
 // start serial
 Serial.begin(9600);//(h/w serirl)
 Sserial.begin(9600); //(s/w Serial)
 xbee.begin(Sserial);
}

// continuously reads packets, looking for ZB Receive or Modem Status
void loop() 
{
  uint8_t sw=0x00; 
   xbee.readPacket();
    
 //Serial.println("heyy");
 if (xbee.getResponse().isAvailable()) 
 {
  // got something
   
  if (xbee.getResponse().getApiId() == ZB_RX_RESPONSE) 
  {
   xbee.getResponse().getZBRxResponse(rx);

   //Serial.println("packet length is ");
   //Serial.println(rx.getPacketLength(), DEC);
   uint8_t data[3];
   packet[19]=rx.getData()[2];
   for (int i = 0; i < rx.getDataLength(); i++) 
   {
    data[i]=rx.getData()[i];
   }
   for (int i=0;i<3;i++)
    Serial.println(data[i]);
   
   if(data[0]==0x01) //read or write
   {
     Serial.println("got packet");
     sw=data[2]; //  
     int l=0;
     for(int i=7;i>=0;i--)
     {
      if(sw&(1<<i))
       digitalWrite((l+4),HIGH);
      else
       digitalWrite((l+4),LOW);
      l++;
     }
     Serial.println("switches toggled");
   }
    else if(data[0]==0x02)
    {
      //2= request 1= set 3= reply
     
      Serial.println("got Req");
      packet[DATSTRT+0]=0X03;
      packet[DATSTRT+1]=0X01;
      chksum();
      Serial.print(packet[19]);
      for(int i=0;i<21;i++)
        Serial.print(packet[i]);
        
      if(Sserial.write(packet,21))
      Serial.println("sending");
      else
      Serial.println("fail");
     
    }
   }
  }
 }


  

