# java-microservice-k8s
Java microservice com Kubernetes

- App simples para conversão de moeda.
- São 2 serviços: currency-conversion e currency-exchange.
- deployment.yaml criado para apply em cluster Kubernetes.

## Versão 0.0.1-SNAPSHOT
Cria container image usando plugin 'spring-boot-maven-plugin'.
Utiliza Buildpacks image.

## Versão 0.0.2-SNAPSHOT
Cria container image usando plugin 'jib-maven-plugin' (Google).
Utiliza ibm-semeru-runtimes:open-17.0.1_12-jre-centos7 image.
