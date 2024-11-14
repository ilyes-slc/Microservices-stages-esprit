{{/* Define a helper to generate the full POstgres connection URL */}}
{{- define "my-spring-app.fullPostgresConnectionURL" -}}
jdbc:postgresql://{{ .Release.Name }}-postgres-service:5432/{{ .Values.postgres.databaseName }}
{{- end -}}