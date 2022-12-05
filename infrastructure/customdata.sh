#!/bin/bash

apt-get update -y
apt-get install -y \
    ca-certificates \
    curl \
    gnupg \
    lsb-release
mkdir -p /etc/apt/keyrings
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo gpg --dearmor -o /etc/apt/keyrings/docker.gpg
echo \
  "deb [arch=$(dpkg --print-architecture) signed-by=/etc/apt/keyrings/docker.gpg] https://download.docker.com/linux/ubuntu \
  $(lsb_release -cs) stable" | sudo tee /etc/apt/sources.list.d/docker.list > /dev/null
apt-get update -y
sleep 30
apt-get install -y docker.io
systemctl start docker
systemctl enable docker
systemctl restart docker
sleep 10
if [ $(hostname) == "vm-postgres" ]; then
  docker run -p 5432:5432 -e POSTGRES_PASSWORD=password -d postgres
  sleep 30
  docker exec $(docker ps | awk '{print $1}' | awk 'NR == 2') psql -U postgres -c "CREATE DATABASE postgresdb;"
elif [ $(hostname) == "vm-mongo" ]; then
  docker run -p 27017:27017 -e MONGO_INITDB_ROOT_USERNAME=root -e MONGO_INITDB_ROOT_PASSWORD=root -d mongo
elif [ $(hostname) == "vm-cassandra" ]; then
  docker run -p 9042:9042 -d cassandra
  sleep 180
  docker exec $(docker ps | awk '{print $1}' | awk 'NR == 2') cqlsh -e "CREATE KEYSPACE IF NOT EXISTS cassandra WITH REPLICATION = {'class':'SimpleStrategy','replication_factor':1};"
fi