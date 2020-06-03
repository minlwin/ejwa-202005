package com.jdc.jersey.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;

import com.jdc.jersey.entity.Member;
import com.jdc.jersey.repo.MemberRepo;

@Path("/members")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Members {
	
	@Autowired
	private MemberRepo repo;
	
	@Context
	private UriInfo uriInfo;
	
	@GET
	public Response getAll() {
		List<Member> list = repo.findAll();
		return Response.ok(list).build();
	}
	
	@GET
	@Path("/{id}")
	public Response findById(int id) {
		return repo.findById(id).map(m -> Response.ok(m)).orElse(Response.noContent()).build();
	}
	
	@POST
	public Response create(Member member) {
		repo.save(member);
		return Response.created(uriInfo.getAbsolutePath()).build();
	}

}
