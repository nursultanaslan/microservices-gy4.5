#Container'ımı nasıl oluşturayım?
#Benim oluşturacağım bu image için gereksinimlerim neler?
#Multi-Stage: runtimeda sadece jre ve çalıştırılabilir .jar dosyasını içerir
#Derleme araçları (maven, JDK) son image'da yoktur

#maven sadece build aşamasında kullanılıyor
FROM maven:3.9-eclipse-temurin-21 AS builder

WORKDIR /build

#pom.xml'i builde kopyalar
COPY pom.xml ./
#maven bağımlılıklarını temizler
RUN mvn -DskipTests dependency:purge-local-repository
#pom.xml hariç geriye kalan bütün kaynak kodları kopyalar
COPY . .
#projeyi derler .jar dosyasını oluşturur
RUN mvn -U clean package -DskipTests
#runtime aşaması:

FROM eclipse-temurin:21-jre AS runtime
#builder aşamasında oluşturulan build/target altındaki .jar dosyasını /app/app.jar'a kopyalar
COPY --from=builder /build/target/*-SNAPSHOT.jar /app/app.jar

ENTRYPOINT ["java", "-jar", "/app/app.jar"]