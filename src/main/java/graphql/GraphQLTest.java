package graphql;

import graphql.schema.GraphQLSchema;
import graphql.schema.StaticDataFetcher;
import graphql.schema.idl.*;

import java.util.function.UnaryOperator;

import static graphql.schema.idl.RuntimeWiring.newRuntimeWiring;

/**
 * GraphQL
 */
public class GraphQLTest {

    private static final int testNumber = 1;

    public static void main(String[] args) {

        String schema = "type Query{hello: String} schema{query: Query}";

        SchemaParser schemaParser = new SchemaParser();
        TypeDefinitionRegistry typeDefinitionRegistry = schemaParser.parse(schema);

        RuntimeWiring runtimeWiring = newRuntimeWiring()
                .type("Query", new UnaryOperator<TypeRuntimeWiring.Builder>() {
                    @Override
                    public TypeRuntimeWiring.Builder apply(TypeRuntimeWiring.Builder builder) {
                        return builder.dataFetcher("hello", new StaticDataFetcher("world"));
                    }
                })
                .build();

        SchemaGenerator schemaGenerator = new SchemaGenerator();
        GraphQLSchema graphQLSchema = schemaGenerator.makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);

        GraphQL build = GraphQL.newGraphQL(graphQLSchema).build();
        ExecutionResult executionResult = build.execute("{hello}");

        System.out.println(executionResult.getData().toString());
        // Prints: {hello=world}
    }
}
